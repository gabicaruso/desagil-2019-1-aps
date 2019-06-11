package br.pro.hashi.ensino.desagil.aps.model;

public class AndGate extends Gate {
    private final NandGate nandA;
    private final NandGate nandB;


    public AndGate() {
        super(1);

        nandA = new NandGate();
        nandB = new NandGate();
    }


    @Override
    public boolean read() {
        return nandB.read();
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        if (inputPin < 0 || inputPin > 1) {
            throw new IndexOutOfBoundsException(inputPin);
        } else if (inputPin == 0) {
            nandA.connect(0, emitter);
        } else if (inputPin == 1) {
            nandA.connect(1, emitter);
        }

        nandB.connect(0, nandA);
        nandB.connect(1, nandA);
    }
}