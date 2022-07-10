package fun.bb1.objects;

import java.util.concurrent.ConcurrentHashMap;

import org.jetbrains.annotations.NotNull;

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
