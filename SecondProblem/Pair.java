package SecondProblem;

class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pair)) return false;
    Pair<?, ?> p = (Pair<?, ?>) o;
    return first.equals(p.first) && second.equals(p.second);
}

@Override
public int hashCode() {
    return 31 * first.hashCode() + second.hashCode();
}

@Override
public String toString() {
    return "[" + first + " , " + second + "]";
}

}
