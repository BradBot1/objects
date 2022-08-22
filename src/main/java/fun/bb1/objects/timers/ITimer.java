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
 * A way to store information to do with timing
 * 
 * @author BradBot_1
 */
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
