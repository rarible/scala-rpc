package scalether.generator.domain;

public enum Type {
    SCALA("", "", "", "", "", "", "cats.Functor", "com.rarible.cats.MonadThrowable", "cats.implicits._"),
    MONO("Mono", "reactor.core.publisher.Mono", "com.rarible.cats.implicits._", "MonoTransactionSender", "MonoTransactionPoller", "MonoPreparedTransaction"),
    ID("Id", "cats.Id", "com.rarible.cats.implicits._", "IdTransactionSender", "IdTransactionPoller", "IdPreparedTransaction");

    private final String f;
    private final String monadType;
    private final String monadImport;
    private final String transactionSender;
    private final String transactionPoller;
    private final String preparedTransaction;
    private final String[] imports;

    Type(String f, String monadType, String monadImport, String transactionSender, String transactionPoller, String preparedTransaction, String... imports) {
        this.f = f;
        this.monadType = monadType;
        this.monadImport = monadImport;
        this.transactionSender = transactionSender;
        this.transactionPoller = transactionPoller;
        this.preparedTransaction = preparedTransaction;
        this.imports = imports;
    }

    public String getF() {
        return f;
    }

    public String getMonadType() {
        return monadType;
    }

    public String getMonadImport() {
        return monadImport;
    }

    public String getTransactionSender() {
        return transactionSender;
    }

    public String getTransactionPoller() {
        return transactionPoller;
    }

    public String getPreparedTransaction() {
        return preparedTransaction;
    }

    public String[] getImports() {
        return imports;
    }
}
