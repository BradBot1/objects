package fun.bb1.objects.statics;

import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.defineables.IStaticMethodsOnly;

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
 * A collection of static methods to create an array that fulfils a desired range
 * 
 * @author BradBot_1
 */
public final class RangeUtils implements IStaticMethodsOnly {
	
	private RangeUtils() { }
	
	public static final @NotNull float[] buildRange(final @NotNull float start, final int steps, final @NotNull float stepSize) {
		final float[] arr = new float[steps];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = start + (i * stepSize);
		}
		return arr;
	}
	
	public static final @NotNull float[] buildRange(final @NotNull float start, final float steps) {
		return buildRange(start, steps);
	}
	
	public static final @NotNull float[] buildRange(final @NotNull float steps) {
		return buildRange(0, steps);
	}
	
	public static final @NotNull long[] buildRange(final @NotNull long start, final int steps, final @NotNull long stepSize) {
		final long[] arr = new long[steps];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = start + (i * stepSize);
		}
		return arr;
	}
	
	public static final @NotNull long[] buildRange(final @NotNull long start, final long steps) {
		return buildRange(start, steps);
	}
	
	public static final @NotNull long[] buildRange(final @NotNull long steps) {
		return buildRange(0, steps);
	}
	
	public static final @NotNull int[] buildRange(final @NotNull int start, final int steps, final @NotNull int stepSize) {
		final int[] arr = new int[steps];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = start + (i * stepSize);
		}
		return arr;
	}
	
	public static final @NotNull int[] buildRange(final @NotNull int start, final int steps) {
		return buildRange(start, steps);
	}
	
	public static final @NotNull int[] buildRange(final @NotNull int steps) {
		return buildRange(0, steps);
	}
	
}
