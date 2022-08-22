package fun.bb1.objects.timers;

import org.jetbrains.annotations.NotNull;

/**
 * 
 * Copyright 2022 BradBot_1
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * An implementation of {@link IPausableTimer} that utilises {@link System#currentTimeMillis()}
 * 
 * @author BradBot_1
 */
public final class SystemTimer implements IPausableTimer {
	
	private long systemTimeInMs;
	private boolean paused = false;
	
	public SystemTimer(final long systemTimeInMs) {
		this(systemTimeInMs, false);
	}
	
	public SystemTimer(final long systemTimeInMs, final boolean relative) {
		this.systemTimeInMs = relative ? (System.currentTimeMillis() + systemTimeInMs) : systemTimeInMs;
	}
	
	private SystemTimer(final long systemTimeInMs, final boolean relative, final boolean paused) {
		this.paused = paused;
		this.systemTimeInMs = relative ? (System.currentTimeMillis() + systemTimeInMs) : systemTimeInMs;
	}
	
	@Override
	public long getTimeRemaining() {
		return System.currentTimeMillis() - this.systemTimeInMs;
	}

	@Override
	public void pause() {
		if (this.paused) return;
		this.paused = true;
		this.systemTimeInMs = this.getTimeRemaining();
	}

	@Override
	public void unpause() {
		if (!this.paused) return;
		this.paused = false;
		this.systemTimeInMs = this.systemTimeInMs + System.currentTimeMillis();
	}

	@Override
	public boolean isPaused() {
		return this.paused;
	}
	
	@Override
	public SystemTimer clone() {
		return new SystemTimer(this.systemTimeInMs, false, this.paused);
	}

	@Override
	public @NotNull String formatTimeRemaining() {
		return this.hasEnded() ? "Ended" : (this.getTimeRemaining() + "ms");
	}
	
}
