import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class Titulo implements Subject {
    private String codigo;
    private double valorCompra;
    private double valorVenda;
    private String tipo;
    private DateFormat dataVencimento;
    private DateFormat dataLancamento;
    private List<Listener> listeners;

    public Titulo(String codigo, double valorCompra, double valorVenda, String tipo, DateFormat dataVencimento,
                  DateFormat dataLancamento) {
        this.codigo = codigo;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.tipo = tipo;
        this.dataVencimento = dataVencimento;
        this.dataLancamento = dataLancamento;
        this.listeners = new ArrayList<Listener>();
    }

    public void notifyListener(Listener listener) {
        listener.update(this); 
    }
    
    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update(this);
        }
    }

    public void subscribeListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void unsubscribeListener(Listener listener) {
        int i = this.listeners.indexOf(listener);
        if (i >= 0) {
            this.listeners.remove(i);
        }
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
        notifyListeners();
    }
    public double getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
        notifyListeners();
    }
    public double getValorVenda() {
        return valorVenda;
    }
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
        notifyListeners();
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
        notifyListeners();
    }
    public DateFormat getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(DateFormat dataVencimento) {
        this.dataVencimento = dataVencimento;
        notifyListeners();
    }
    public DateFormat getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(DateFormat dataLancamento) {
        this.dataLancamento = dataLancamento;
        notifyListeners();
    }

    @Override
    public String toString() {
        return "Titulo{" +
               "codigo='" + codigo + '\'' +
               ", valorCompra=" + valorCompra +
               ", valorVenda=" + valorVenda +
               ", tipo='" + tipo + '\'' +
               ", dataVencimento=" + dataVencimento +
               ", dataLancamento=" + dataLancamento +
               '}';
    }
}