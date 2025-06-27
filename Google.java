class Google implements Listener {
    @Override
    public void update(Titulo titulo) {
        System.out.println("Google notified: " + titulo.toString());
    }
}