package fun.bb1.objects;

import java.util.Map.Entry;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public final class Primitive implements Cloneable {
	
	private final @NotNull Object innerPrimitive;
	
	public Primitive(@NotNull final String given) {
		this.innerPrimitive = given;
	}
	
	public Primitive(@NotNull final Number given) {
		this.innerPrimitive = given;
	}
	
	public Primitive(@NotNull final char given) {
		this.innerPrimitive = given;
	}
	
	public Primitive(@NotNull final boolean given) {
		this.innerPrimitive = given;
	}
	
	public Primitive(@NotNull final Primitive[] given) {
		this.innerPrimitive = given;
	}
	
	public Primitive(@NotNull final PrimitiveMap<?> given) {
		this.innerPrimitive = given;
	}
	
	private Primitive(@NotNull final Object obj) {
		this.innerPrimitive = obj;
	}
	
	@Override
	public final String toString() {
		return "Primitive{innerPrimitive=" + this.innerPrimitive.toString() + ",type=" + this.innerPrimitive.getClass() + ",stringifiedInnerPrimitive=\"" + this.getAsString() + "\"}";
	}
	
	public final @NotNull String getAsString() {
		if (this.innerPrimitive instanceof String str) return str;
		if (this.innerPrimitive instanceof Boolean bool) return Boolean.toString(bool);
		if (this.innerPrimitive instanceof Character cha) return new StringBuilder(cha).toString();
		if (this.innerPrimitive instanceof Number num) {
			if (num instanceof Integer in) return Integer.toString(in);
			if (num instanceof Double in) return Double.toString(in);
			if (num instanceof Float in) return Float.toString(in);
			if (num instanceof Long in) return Long.toString(in);
			if (num instanceof Byte in) return Byte.toString(in);
			if (num instanceof Short in) return Short.toString(in);
			return Double.toString(num.doubleValue());
		}
		if (this.innerPrimitive instanceof Primitive[] primArr) {
			if (primArr.length == 0) return "[]";
			final StringBuilder builder = new StringBuilder('[');
			for (final Primitive prim : primArr) {
				if (prim == null) continue;
				builder.append(prim.isString() ? '"' + prim.getAsString() + '"' : prim.getAsString()).append(',');
			}
			return builder.deleteCharAt(builder.length() - 1).append(']').toString();
		}
		if (this.innerPrimitive instanceof PrimitiveMap<?> map) {
			if (map.size() == 0) return "{}";
			final StringBuilder builder = new StringBuilder('{');
			for (final Entry<?, Primitive> entry : map.entrySet()) {
				builder.append(entry.getKey() instanceof CharSequence seq ? '"' + seq.toString() + '"' : entry.getKey().toString()).append(':').append(entry.getValue().isString() ? '"' + entry.getValue().getAsString() + '"' : entry.getValue().getAsString()).append(',');
			}
			return builder.deleteCharAt(builder.length() - 1).append('}').toString();
		}
		return this.innerPrimitive.toString();
	}
	/**
	 * Forwards to {@link #getAsBoolean(boolean)} with false as the fallback case
	 */
	public final boolean getAsBoolean() {
		return this.getAsBoolean(false);
	}
	
	public final boolean getAsBoolean(final boolean fallbackCase) {
		if (this.innerPrimitive instanceof Boolean bool) return bool.booleanValue();
		if (this.innerPrimitive instanceof Number num) return num.longValue()>=1;
		if (this.innerPrimitive instanceof Character cha) return Character.toLowerCase(cha) == 'y' || Character.toLowerCase(cha) == 't';
		if (this.innerPrimitive instanceof String str) return str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("true") || str.equalsIgnoreCase("y") || str.equalsIgnoreCase("t");
		if (this.innerPrimitive instanceof Primitive[] primArr) return primArr.length > 0;
		if (this.innerPrimitive instanceof PrimitiveMap<?> map) return map.size() > 0;
		return fallbackCase;
	}
	
	public final @NotNull Number getAsNumber() {
		if (this.innerPrimitive instanceof Number num) return num;
		if (this.innerPrimitive instanceof Character cha) return (long) cha.charValue();
		if (this.innerPrimitive instanceof Boolean bool) return bool ? 1 : 0;
		if (this.innerPrimitive instanceof String str) {
			try {
				return str.contains(".") ? Double.parseDouble(str) : Long.parseLong(str);
			} catch (Throwable e) {
				return str.length();
			}
		}
		if (this.innerPrimitive instanceof Primitive[] primArr) return primArr.length;
		if (this.innerPrimitive instanceof PrimitiveMap<?> map) return map.size();
		return Float.NaN;
	}
	
	public final char getAsCharacter() {
		if (this.innerPrimitive instanceof Character cha) return cha.charValue();
		if (this.innerPrimitive instanceof Number num) return (char) num.longValue();
		if (this.innerPrimitive instanceof String str) return str.length()>0 ? str.charAt(0) : (char) 0;
		if (this.innerPrimitive instanceof Boolean bool) return bool ? 't' : 'f';
		if (this.innerPrimitive instanceof Primitive[] primArr) return (char) primArr.length;
		if (this.innerPrimitive instanceof PrimitiveMap<?> map) return (char) map.size();
		return (char) 0;
	}
	
	public final @NotNull Primitive[] getAsArray() {
		if (this.innerPrimitive instanceof Primitive[] primArr) return primArr;
		return new Primitive[] { this };
	}
	
	public final @NotNull PrimitiveMap<?> getAsMap() {
		if (this.innerPrimitive instanceof PrimitiveMap<?> map) return map;
		final PrimitiveMap<String> generatedMap = new PrimitiveMap<String>();
		generatedMap.put("primitive", this);
		return generatedMap;
	}
	
	public final @NotNull PrimitiveMap<String> getAsStringBasedMap() {
		final PrimitiveMap<?> map = this.getAsMap();
		return map.entrySet().stream().collect(()->new PrimitiveMap<String>(),
											   (m,e)->{ m.put(e.getKey() instanceof Primitive prim ? prim.getAsString() : e.getKey().toString(), e.getValue()); },
											   (m,m2)->{ m.putAll(m2); });
	}
	
	public final boolean isString() {
		return this.innerPrimitive instanceof String;
	}
	
	public final boolean isBoolean() {
		return this.innerPrimitive instanceof Boolean;
	}
	
	public final boolean isNumber() {
		return this.innerPrimitive instanceof Number;
	}
	
	public final boolean isCharacter() {
		return this.innerPrimitive instanceof Character;
	}
	
	public final boolean isArray() {
		return this.innerPrimitive instanceof Primitive[];
	}
	
	public final boolean isMap() {
		return this.innerPrimitive instanceof PrimitiveMap<?>;
	}
	
	@Override
	public final boolean equals(Object obj) {
		return this.innerPrimitive.equals(obj instanceof Primitive prim ? prim.getInner() : obj); 
	}
	
	public final @NotNull Object getInner() {
		return this.innerPrimitive;
	}
	
	@Override
	public final int hashCode() {
		return Objects.hash(this.innerPrimitive);
	}
	
	@Override
	public final @NotNull Primitive clone() {
		try {
			final Object clonedInner = Object.class.getMethod("clone").invoke(this.innerPrimitive);
			if (clonedInner != null && this.innerPrimitive instanceof Cloneable) return new Primitive(clonedInner);
		} catch (Throwable e) { } // To deal with security issues
		return new Primitive(this.innerPrimitive);
	}
	
}
