package fun.bb1.objects.timers;

import org.jetbrains.annotations.NotNull;

public final class SystemTimer implements IPausableTimer {
	
	private long systemTimeInMs;
	private boolean paused = false;
	
	public SystemTimer(final long systemTimeInMs) {
		this(systemTimeInMs, false);
	}
	
	public SystemTimer(final long systemTimeInMs, final boolean relative) {
		this.systemTimeInMs = relative ? (System.currentTimeMillis() + systemTimeInMs) : systemTimeInMs;
	}
	
	SystemTimer(final long systemTimeInMs, final boolean relative, final boolean paused) {
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
