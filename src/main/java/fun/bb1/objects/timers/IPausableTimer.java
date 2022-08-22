package fun.bb1.objects.timers;

public interface IPausableTimer extends ITimer {
	
	public void pause();
	
	public void unpause();
	
	public boolean isPaused();
	
	@Override
	public default boolean hasEnded() {
		return !this.isPaused() && this.getTimeRemaining() <= 0;
	}
	
}
