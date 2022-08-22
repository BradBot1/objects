package fun.bb1.objects;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
 * Used to contain a {@link Map} where a {@link Primitive} is always the type of a given value
 * 
 * @author BradBot_1
 */
public final class PrimitiveMap<K> extends ConcurrentHashMap<K, Primitive> {
	
	private static final long serialVersionUID = -2863274313069676442L;
	
	public final @NotNull Primitive put(@NotNull final K key, @NotNull final String value) {
		return this.put(key, new Primitive(value));
	}
	
	public final @NotNull Primitive put(@NotNull final K key, @NotNull final Character value) {
		return this.put(key, new Primitive(value));
	}
	
	public final @NotNull Primitive put(@NotNull final K key, @NotNull final Boolean value) {
		return this.put(key, new Primitive(value));
	}
	
	public final @NotNull Primitive put(@NotNull final K key, @NotNull final Number value) {
		return this.put(key, new Primitive(value));
	}
	
	public final @NotNull Primitive put(@NotNull final K key, @NotNull final Primitive[] value) {
		return this.put(key, new Primitive(value));
	}
	
	public final @NotNull Primitive put(@NotNull final K key, @NotNull final PrimitiveMap<?> value) {
		return this.put(key, new Primitive(value));
	}
	
}
