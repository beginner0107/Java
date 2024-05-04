package reflection.exercises.polymorphism.udp;

public class UdpClient {
    public boolean sendAndForget(String requestPayload) {
        System.out.println(String.format("Request : %s was sent through UDP", requestPayload));
        return true;
    }
}
