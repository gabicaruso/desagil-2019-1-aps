package br.pro.hashi.ensino.desagil.aps.model;

public  class HalfAdder extends Gate {
    private final NandGate nandA;
    private final NandGate nandB;
    private final NandGate nandC;
    private final NandGate nandSum;
    private final NandGate nandCarry;

    public HalfAdder() {
        super("Half-Adder", 2, 2);

        nandA = new NandGate();
        nandB = new NandGate();
        nandC = new NandGate();
        nandSum = new NandGate();
        nandCarry = new NandGate();

        nandB.connect(1, nandA);
        nandC.connect(0, nandA);

        nandSum.connect(0, nandB);
        nandSum.connect(1, nandC);

        nandCarry.connect(0, nandA);
        nandCarry.connect(1, nandA);

    }


    @Override
    public boolean read(int outputPin) {
        if (outputPin == 0) {
            return nandSum.read();
        }

        if (outputPin == 1) {
            return nandCarry.read();
        }

        else {
            throw new IndexOutOfBoundsException(outputPin);
        }
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        switch (inputPin) {
            case 0:
                nandA.connect(0, emitter);
                nandB.connect(0, emitter);
                break;
            case 1:
                nandA.connect(1, emitter);
                nandC.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputPin);
        }
    }
}
