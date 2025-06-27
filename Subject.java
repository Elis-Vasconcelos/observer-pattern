public interface Subject {
    public void notifyListener(Listener l);
    public void subscribeListener(Listener l);
    public void unsubscribeListener(Listener l);
}
