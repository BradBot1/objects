package fun.bb1.objects.timers;

import org.jetbrains.annotations.NotNull;

public interface ITimer extends Cloneable {
	
	public static @NotNull ITimer delay(final long relativeDelay) {
		return new SystemTimer(relativeDelay, true);
	}
	
	public long getTimeRemaining();
	
	public default @NotNull String formatTimeRemaining() {
		return this.hasEnded() ? "Ended" : Long.toString(this.getTimeRemaining());
	}
	
	public default boolean hasEnded() {
		return this.getTimeRemaining() <= 0;
	}
	
}
