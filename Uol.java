class Uol implements Listener {
    @Override
    public void update(Titulo titulo) {
        System.out.println("Uol notified: " + titulo.toString());
    }
}