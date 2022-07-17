package fun.bb1.objects.exceptions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.defineables.IImmutable;

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
 * Called when an {@link IImmutable} object is modified
 * 
 * @author BradBot_1
 */
public class ImmutableModificationException extends RuntimeException {
	
	private static final long serialVersionUID = -1135151762289176158L;
	
	private final @Nullable IImmutable modified;
	
	public ImmutableModificationException(@NotNull final String message) {
		this(message, null);
	}
	
	public ImmutableModificationException(@NotNull final IImmutable caller) {
		this("You cannot modify an immutable object (" + caller.getClass().getName() + ')', caller);
	}
	
	public ImmutableModificationException(@NotNull final String message, @Nullable final IImmutable caller) {
		super(message);
		this.modified = caller;
	}
	
	public final @NotNull IImmutable getModified() {
		return this.modified;
	}
	
}
