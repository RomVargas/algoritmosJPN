package streams.reference_methods;

import java.util.UUID;
import java.util.function.Supplier;

public class StaticMethodReference {
    public static void main(String[] args) {
        Supplier<UUID> token = () -> UUID.randomUUID();
        Supplier<UUID> tokenReferenciado = UUID::randomUUID;
        System.out.println(token.get());
        System.out.println(tokenReferenciado.get());
    }
}
