/* VoiceManager.cpp
* Class responsible for managing voice that are currently free and being used
* @author: Jon Patman | CS 360
*/

#include "VoiceManager.h"

// Finds the next free Voice
Voice* VoiceManager::findFreeVoice() {
	Voice* freeVoice = NULL;
	for (int i = 0; i < NumberOfVoices; i++) {
		if (!voices[i].isActive) {
			freeVoice = &(voices[i]);
			break;
		}
	}
	return freeVoice;
}
// Starts the cycle if a note is triggered
void VoiceManager::onNoteOn(int noteNumber, int velocity) {
	Voice* voice = findFreeVoice();
	if (!voice) {
		return;
	}
	voice->reset();
	voice->setNoteNumber(noteNumber);
	voice->mVelocity = velocity;
	voice->isActive = true;
	voice->mVolumeEnvelope.enterStage(EnvelopeGenerator::ENVELOPE_STAGE_ATTACK);
	voice->mFilterEnvelope.enterStage(EnvelopeGenerator::ENVELOPE_STAGE_ATTACK);
}
// Turns off the cycle when the note is released
void VoiceManager::onNoteOff(int noteNumber, int velocity) {
	// Find the voice(s) with the given noteNumber:
	for (int i = 0; i < NumberOfVoices; i++) {
		Voice& voice = voices[i];
		if (voice.isActive && voice.mNoteNumber == noteNumber) {
			voice.mVolumeEnvelope.enterStage(EnvelopeGenerator::ENVELOPE_STAGE_RELEASE);
			voice.mFilterEnvelope.enterStage(EnvelopeGenerator::ENVELOPE_STAGE_RELEASE);
		}
	}
}
// Gets the next sample of the currently active Voice
double VoiceManager::nextSample() {
	double output = 0.0;
	double lfoValue = mLFO.nextSample();
	for (int i = 0; i < NumberOfVoices; i++) {
		Voice& voice = voices[i];
		voice.setLFOValue(lfoValue);
		output += voice.nextSample();
	}
	return output;
}

