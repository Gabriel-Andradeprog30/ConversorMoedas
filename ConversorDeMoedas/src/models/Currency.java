package models;

public class Currency {

    private final String currencyBaseCode;
    private final String convertedCurrencyCode;
    private final double amountToConvert;
    private final double convertedAmount;
    private final String lastUpdate;



    public Currency(String currencyBaseCode, String convertedCurrencyCode,
                    double amountToConvert, double convertedAmount, String lastUpdate) {

        this.currencyBaseCode = currencyBaseCode;
        this.convertedCurrencyCode = convertedCurrencyCode;
        this.amountToConvert = amountToConvert;
        this.convertedAmount = convertedAmount;
        this.lastUpdate = lastUpdate.substring(5,lastUpdate.length()-5);
    }



    @Override
    public String toString() {
        return String.format( """
                Conversão realizada de %s para %s
                
                Moeda Inicial: %s
                Moeda Destino: %s
                Valor inicial: $%.2f %s
                Valor convertido: $%.2f %s
                
                Dados atualizado em %s
                """, this.currencyBaseCode, this.convertedCurrencyCode, this.currencyBaseCode,
                this.convertedCurrencyCode, this.amountToConvert, this.currencyBaseCode,
                this.convertedAmount, this.convertedCurrencyCode, this.lastUpdate);
    }
}