/* Oscillator.cpp
* Class responsible for setting Oscillator functions and also for creating
* the oscillator source object used to store values into the input buffer
* @author: Jon Patman |  CS 360
*/

#include "Oscillator.h"

double Oscillator::mSampleRate = 44100.0;

// Sets the mode for the oscillator
void Oscillator::setMode(OscillatorMode mode) {
	mOscillatorMode = mode;
}
// Sets the frequency of the oscillator
void Oscillator::setFrequency(double frequency) {
	mFrequency = frequency;
	updateIncrement();
}
// Sets the sample rate of the oscillator
void Oscillator::setSampleRate(double sampleRate) {
	mSampleRate = sampleRate;
	updateIncrement();
}
// Stores the generated sample into the buffer
void Oscillator::generate(double* buffer, int nFrames) {
	const double twoPI = 2 * mPI;
	switch (mOscillatorMode) {
	case OSCILLATOR_MODE_SINE:
		for (int i = 0; i < nFrames; i++) {
			buffer[i] = sin(mPhase);
			mPhase += mPhaseIncrement;
			while (mPhase >= twoPI) {
				mPhase -= twoPI;
			}
		}
		break;
	case OSCILLATOR_MODE_SAW:
		for (int i = 0; i < nFrames; i++) {
			buffer[i] = 1.0 - (2.0 * mPhase / twoPI);
			mPhase += mPhaseIncrement;
			while (mPhase >= twoPI) {
				mPhase -= twoPI;
			}
		}
		break;
	case OSCILLATOR_MODE_SQUARE:
		for (int i = 0; i < nFrames; i++) {
			if (mPhase <= mPI) {
				buffer[i] = 1.0;
			}
			else {
				buffer[i] = -1.0;
			}
			mPhase += mPhaseIncrement;
			while (mPhase >= twoPI) {
				mPhase -= twoPI;
			}
		}
		break;
	case OSCILLATOR_MODE_TRIANGLE:
		for (int i = 0; i < nFrames; i++) {
			double value = -1.0 + (2.0 * mPhase / twoPI);
			buffer[i] = 2.0 * (fabs(value) - 0.5);
			mPhase += mPhaseIncrement;
			while (mPhase >= twoPI) {
				mPhase -= twoPI;
			}
		}
		break;
	}
}
// Gets the next sample for the oscillator
double Oscillator::nextSample() {
	double value = 0.0;

	switch (mOscillatorMode) {
	case OSCILLATOR_MODE_SINE:
		value = sin(mPhase);
		break;
	case OSCILLATOR_MODE_SAW:
		value = 1.0 - (2.0 * mPhase / twoPI);
		break;
	case OSCILLATOR_MODE_SQUARE:
		if (mPhase <= mPI) {
			value = 1.0;
		}
		else {
			value = -1.0;
		}
		break;
	case OSCILLATOR_MODE_TRIANGLE:
		value = -1.0 + (2.0 * mPhase / twoPI);
		value = 2.0 * (fabs(value) - 0.5);
		break;
	}
	mPhase += mPhaseIncrement;
	while (mPhase >= twoPI) {
		mPhase -= twoPI;
	}
	return value;
}
// Sets the pitch modulation for the oscillator
void Oscillator::setPitchMod(double amount) {
	mPitchMod = amount;
	updateIncrement();
}

void Oscillator::updateIncrement() {
	double pitchModAsFrequency = pow(2.0, fabs(mPitchMod) * 14.0) - 1;
	if (mPitchMod < 0) {
		pitchModAsFrequency = -pitchModAsFrequency;
	}
	double calculatedFrequency = fmin(fmax(mFrequency + pitchModAsFrequency, 0), mSampleRate / 2.0);
	mPhaseIncrement = calculatedFrequency * 2 * mPI / mSampleRate;
}
