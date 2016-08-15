class Dmgcpu {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    public int sp;
    public int pc;
    public int hl;
    int instrCount = 0;
    boolean interruptsEnabled = false;
    int ieDelay = -1;
    boolean timaEnabled = false;
    int instrsPerTima = 6000;
    boolean inInterrupt = false;
    boolean breakpointEnable = false;
    final short F_ZERO = 128;
    final short F_SUBTRACT = 64;
    final short F_HALFCARRY = 32;
    final short F_CARRY = 16;
    final short INSTRS_PER_VBLANK = 9000;
    final short BASE_INSTRS_PER_HBLANK = 60;
    short INSTRS_PER_HBLANK = BASE_INSTRS_PER_HBLANK;
    final short BASE_INSTRS_PER_DIV = 33;
    short INSTRS_PER_DIV = BASE_INSTRS_PER_DIV;
    public final short INT_VBLANK = 1;
    public final short INT_LCDC = 2;
    public final short INT_TIMA = 4;
    public final short INT_SER = 8;
    public final short INT_P10 = 16;
    java.lang.String[] registerNames = { "B", "C", "D", "E", "H", "L", "(HL)",
    "A" };
    java.lang.String[] aluOperations = { "ADD", "ADC", "SUB", "SBC", "AND",
    "XOR",
    "OR",
    "CP" };
    java.lang.String[] shiftOperations = { "RLC", "RRC", "RL", "RR", "SLA",
    "SRA",
    "SWAP",
    "SRL" };
    byte[] mainRam = new byte[32768];
    byte[] oam = new byte[256];
    Cartridge cartridge;
    GraphicsChip graphicsChip;
    SoundChip soundChip;
    GameLink gameLink;
    IoHandler ioHandler;
    java.awt.Component applet;
    boolean terminate;
    boolean running = false;
    boolean gbcFeatures = true;
    boolean allowGbcFeatures = true;
    int gbcRamBank = 1;
    public Dmgcpu(Cartridge c, GameLink l, java.awt.Component a) { super(
                                                                     );
                                                                   cartridge =
                                                                     c;
                                                                   gameLink =
                                                                     l;
                                                                   if (gameLink !=
                                                                         null)
                                                                       gameLink.
                                                                         setDmgcpu(
                                                                           this);
                                                                   graphicsChip =
                                                                     new TileBasedGraphicsChip(
                                                                       a,
                                                                       this);
                                                                   checkEnableGbc(
                                                                     );
                                                                   boolean java1point3 =
                                                                     true;
                                                                   java.lang.String version =
                                                                     java.lang.System.
                                                                     getProperty(
                                                                       "java.version");
                                                                   java1point3 =
                                                                     !(version.
                                                                         startsWith(
                                                                           "1.0") ||
                                                                         version.
                                                                         startsWith(
                                                                           "1.1"));
                                                                   if (java1point3) {
                                                                       soundChip =
                                                                         new SoundChip(
                                                                           );
                                                                   }
                                                                   ioHandler =
                                                                     new IoHandler(
                                                                       this);
                                                                   applet =
                                                                     a;
    }
    public void dispose() { graphicsChip.
                              dispose(
                                ); }
    public void terminateProcess() { terminate =
                                       true;
    }
    public final short addressRead(int addr) {
        addr =
          addr &
            65535;
        switch (addr &
                  61440) {
            case 0:
            case 4096:
            case 8192:
            case 12288:
            case 16384:
            case 20480:
            case 24576:
            case 28672:
                return cartridge.
                  addressRead(
                    addr);
            case 32768:
            case 36864:
                return graphicsChip.
                  addressRead(
                    addr -
                      32768);
            case 40960:
            case 45056:
                return cartridge.
                  addressRead(
                    addr);
            case 49152:
                return mainRam[addr -
                                 49152];
            case 53248:
                return mainRam[addr -
                                 53248 +
                                 gbcRamBank *
                                 4096];
            case 57344:
                return mainRam[addr -
                                 57344];
            case 61440:
                if (addr <
                      65024) {
                    return mainRam[addr -
                                     57344];
                }
                else
                    if (addr <
                          65280) {
                        return (short)
                                 (oam[addr -
                                        65024] &
                                    255);
                    }
                    else {
                        return ioHandler.
                          ioRead(
                            addr -
                              65280);
                    }
            default:
                java.lang.System.
                  out.
                  println(
                    "Tried to read address " +
                    addr +
                    ".  pc = " +
                    JavaBoy.
                      hexWord(
                        pc));
                return 255;
        }
    }
    public final void addressWrite(int addr,
                                   int data) {
        switch (addr &
                  61440) {
            case 0:
            case 4096:
            case 8192:
            case 12288:
            case 16384:
            case 20480:
            case 24576:
            case 28672:
                if (!running) {
                    cartridge.
                      debuggerAddressWrite(
                        addr,
                        data);
                }
                else {
                    cartridge.
                      addressWrite(
                        addr,
                        data);
                }
                break;
            case 32768:
            case 36864:
                graphicsChip.
                  addressWrite(
                    addr -
                      32768,
                    (byte)
                      data);
                break;
            case 40960:
            case 45056:
                cartridge.
                  addressWrite(
                    addr,
                    data);
                break;
            case 49152:
                mainRam[addr -
                          49152] =
                  (byte)
                    data;
                break;
            case 53248:
                mainRam[addr -
                          53248 +
                          gbcRamBank *
                          4096] =
                  (byte)
                    data;
                break;
            case 57344:
                mainRam[addr -
                          57344] =
                  (byte)
                    data;
                break;
            case 61440:
                if (addr <
                      65024) {
                    try {
                        mainRam[addr -
                                  57344] =
                          (byte)
                            data;
                    }
                    catch (java.lang.ArrayIndexOutOfBoundsException e) {
                        java.lang.System.
                          out.
                          println(
                            "Address error: " +
                            addr +
                            " pc = " +
                            JavaBoy.
                              hexWord(
                                pc));
                    }
                }
                else
                    if (addr <
                          65280) {
                        oam[addr -
                              65024] =
                          (byte)
                            data;
                    }
                    else {
                        ioHandler.
                          ioWrite(
                            addr -
                              65280,
                            (short)
                              data);
                    }
                break;
        }
    }
    public final void addressWriteOld(int addr,
                                      int data) {
        if (addr <
              32768) {
            if (!running) {
                cartridge.
                  debuggerAddressWrite(
                    addr,
                    data);
            }
            else {
                cartridge.
                  addressWrite(
                    addr,
                    data);
            }
        }
        else
            if (addr <
                  40960) {
                try {
                    graphicsChip.
                      addressWrite(
                        addr -
                          32768,
                        (byte)
                          data);
                }
                catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    java.lang.System.
                      out.
                      println(
                        "Error address " +
                        addr);
                }
            }
            else
                if (addr <
                      49152) {
                    cartridge.
                      addressWrite(
                        addr,
                        data);
                }
                else
                    if (addr <
                          57344) {
                        mainRam[addr -
                                  49152] =
                          (byte)
                            data;
                    }
                    else
                        if (addr <
                              65024) {
                            mainRam[addr -
                                      57344] =
                              (byte)
                                data;
                        }
                        else
                            if (addr <
                                  65280) {
                                oam[addr -
                                      65024] =
                                  (byte)
                                    data;
                            }
                            else
                                if (addr <=
                                      65535) {
                                    if (addr ==
                                          65408) {
                                        
                                    }
                                    ioHandler.
                                      ioWrite(
                                        addr -
                                          65280,
                                        (short)
                                          data);
                                }
                                else {
                                    java.lang.System.
                                      out.
                                      println(
                                        "Attempt to write to address " +
                                        JavaBoy.
                                          hexWord(
                                            addr));
                                }
    }
    public boolean setRegister(java.lang.String reg,
                               int value) {
        if (reg.
              equals(
                "a") ||
              reg.
              equals(
                "acc")) {
            a =
              (short)
                value;
        }
        else
            if (reg.
                  equals(
                    "b")) {
                b =
                  (short)
                    value;
            }
            else
                if (reg.
                      equals(
                        "c")) {
                    c =
                      (short)
                        value;
                }
                else
                    if (reg.
                          equals(
                            "d")) {
                        d =
                          (short)
                            value;
                    }
                    else
                        if (reg.
                              equals(
                                "e")) {
                            e =
                              (short)
                                value;
                        }
                        else
                            if (reg.
                                  equals(
                                    "f")) {
                                f =
                                  (short)
                                    value;
                            }
                            else
                                if (reg.
                                      equals(
                                        "h")) {
                                    hl =
                                      hl &
                                        255 |
                                        value <<
                                        8;
                                }
                                else
                                    if (reg.
                                          equals(
                                            "l")) {
                                        hl =
                                          hl &
                                            65280 |
                                            value;
                                    }
                                    else
                                        if (reg.
                                              equals(
                                                "sp")) {
                                            sp =
                                              value;
                                        }
                                        else
                                            if (reg.
                                                  equals(
                                                    "pc") ||
                                                  reg.
                                                  equals(
                                                    "ip")) {
                                                pc =
                                                  value;
                                            }
                                            else
                                                if (reg.
                                                      equals(
                                                        "bc")) {
                                                    b =
                                                      (short)
                                                        (value >>
                                                           8);
                                                    c =
                                                      (short)
                                                        (value &
                                                           255);
                                                }
                                                else
                                                    if (reg.
                                                          equals(
                                                            "de")) {
                                                        d =
                                                          (short)
                                                            (value >>
                                                               8);
                                                        e =
                                                          (short)
                                                            (value &
                                                               255);
                                                    }
                                                    else
                                                        if (reg.
                                                              equals(
                                                                "hl")) {
                                                            hl =
                                                              value;
                                                        }
                                                        else {
                                                            return false;
                                                        }
        return true;
    }
    public void setBC(int value) { b = (short)
                                         ((value &
                                             65280) >>
                                            8);
                                   c = (short)
                                         (value &
                                            255);
    }
    public void setDE(int value) { d = (short)
                                         ((value &
                                             65280) >>
                                            8);
                                   e = (short)
                                         (value &
                                            255);
    }
    public void setHL(int value) { hl = value;
    }
    public final int registerRead(int regNum) {
        switch (regNum) {
            case 0:
                return b;
            case 1:
                return c;
            case 2:
                return d;
            case 3:
                return e;
            case 4:
                return (short)
                         ((hl &
                             65280) >>
                            8);
            case 5:
                return (short)
                         (hl &
                            255);
            case 6:
                return JavaBoy.
                  unsign(
                    addressRead(
                      hl));
            case 7:
                return a;
            default:
                return -1;
        }
    }
    public final void registerWrite(int regNum,
                                    int data) {
        switch (regNum) {
            case 0:
                b =
                  (short)
                    data;
                return;
            case 1:
                c =
                  (short)
                    data;
                return;
            case 2:
                d =
                  (short)
                    data;
                return;
            case 3:
                e =
                  (short)
                    data;
                return;
            case 4:
                hl =
                  hl &
                    255 |
                    data <<
                    8;
                return;
            case 5:
                hl =
                  hl &
                    65280 |
                    data;
                return;
            case 6:
                addressWrite(
                  hl,
                  data);
                return;
            case 7:
                a =
                  (short)
                    data;
                return;
            default:
                return;
        }
    }
    public void checkEnableGbc() { if ((cartridge.
                                          rom[323] &
                                          128) ==
                                         128 &&
                                         allowGbcFeatures) {
                                       gbcFeatures =
                                         true;
                                   }
                                   else {
                                       gbcFeatures =
                                         false;
                                   } }
    public void reset() { checkEnableGbc(
                            );
                          setDoubleSpeedCpu(
                            false);
                          graphicsChip.dispose(
                                         );
                          cartridge.reset(
                                      );
                          interruptsEnabled =
                            false;
                          ieDelay = -1;
                          pc = 256;
                          sp = 65534;
                          f = 176;
                          gbcRamBank = 1;
                          instrCount = 0;
                          if (gbcFeatures) {
                              a =
                                17;
                          }
                          else {
                              a =
                                1;
                          }
                          for (int r = 0;
                               r <
                                 32768;
                               r++) { mainRam[r] =
                                        0;
                          }
                          setBC(19);
                          setDE(216);
                          setHL(333);
                          JavaBoy.debugLog(
                                    "CPU reset");
                          ioHandler.reset(
                                      ); }
    public void setDoubleSpeedCpu(boolean enabled) {
        if (enabled) {
            INSTRS_PER_HBLANK =
              BASE_INSTRS_PER_HBLANK *
                2;
            INSTRS_PER_DIV =
              BASE_INSTRS_PER_DIV *
                2;
        }
        else {
            INSTRS_PER_HBLANK =
              BASE_INSTRS_PER_HBLANK;
            INSTRS_PER_DIV =
              BASE_INSTRS_PER_DIV;
        }
    }
    public final void checkInterrupts() {
        int intFlags =
          ioHandler.
            registers[15];
        int ieReg =
          ioHandler.
            registers[255];
        if ((intFlags &
               ieReg) !=
              0) {
            sp -=
              2;
            addressWrite(
              sp +
                1,
              pc >>
                8);
            addressWrite(
              sp,
              pc &
                255);
            interruptsEnabled =
              false;
            if ((intFlags &
                   ieReg &
                   INT_VBLANK) !=
                  0) {
                pc =
                  64;
                intFlags -=
                  INT_VBLANK;
            }
            else
                if ((intFlags &
                       ieReg &
                       INT_LCDC) !=
                      0) {
                    pc =
                      72;
                    intFlags -=
                      INT_LCDC;
                }
                else
                    if ((intFlags &
                           ieReg &
                           INT_TIMA) !=
                          0) {
                        pc =
                          80;
                        intFlags -=
                          INT_TIMA;
                    }
                    else
                        if ((intFlags &
                               ieReg &
                               INT_SER) !=
                              0) {
                            pc =
                              88;
                            intFlags -=
                              INT_SER;
                        }
                        else
                            if ((intFlags &
                                   ieReg &
                                   INT_P10) !=
                                  0) {
                                pc =
                                  96;
                                intFlags -=
                                  INT_P10;
                            }
            ioHandler.
              registers[15] =
              (byte)
                intFlags;
            inInterrupt =
              true;
        }
    }
    public final void triggerInterrupt(int intr) {
        ioHandler.
          registers[15] |=
          intr;
    }
    public final void triggerInterruptIfEnabled(int intr) {
        if ((ioHandler.
               registers[255] &
               (short)
                 intr) !=
              0)
            ioHandler.
              registers[15] |=
              intr;
    }
    public final void initiateInterrupts() {
        if (timaEnabled &&
              instrCount %
              instrsPerTima ==
              0) {
            if (JavaBoy.
                  unsign(
                    ioHandler.
                      registers[5]) ==
                  0) {
                ioHandler.
                  registers[5] =
                  ioHandler.
                    registers[6];
                if ((ioHandler.
                       registers[255] &
                       INT_TIMA) !=
                      0)
                    triggerInterrupt(
                      INT_TIMA);
            }
            ioHandler.
              registers[5]++;
        }
        if (instrCount %
              INSTRS_PER_DIV ==
              0) {
            ioHandler.
              registers[4]++;
        }
        if (instrCount %
              INSTRS_PER_HBLANK ==
              0) {
            int cline =
              JavaBoy.
              unsign(
                ioHandler.
                  registers[68]) +
              1;
            if (cline ==
                  152)
                cline =
                  0;
            if ((ioHandler.
                   registers[255] &
                   INT_LCDC) !=
                  0 &&
                  (ioHandler.
                     registers[65] &
                     64) !=
                  0 &&
                  JavaBoy.
                  unsign(
                    ioHandler.
                      registers[69]) ==
                  cline &&
                  (ioHandler.
                     registers[64] &
                     128) !=
                  0 &&
                  cline <
                  144) {
                triggerInterrupt(
                  INT_LCDC);
            }
            if ((ioHandler.
                   registers[255] &
                   INT_LCDC) !=
                  0 &&
                  (ioHandler.
                     registers[65] &
                     8) !=
                  0 &&
                  (ioHandler.
                     registers[64] &
                     128) !=
                  0 &&
                  cline <
                  144) {
                triggerInterrupt(
                  INT_LCDC);
            }
            if (gbcFeatures &&
                  ioHandler.
                    hdmaRunning) {
                ioHandler.
                  performHdma(
                    );
            }
            if (JavaBoy.
                  unsign(
                    ioHandler.
                      registers[68]) ==
                  143) {
                for (int r =
                       144;
                     r <
                       170;
                     r++) {
                    graphicsChip.
                      notifyScanline(
                        r);
                }
                if ((ioHandler.
                       registers[64] &
                       128) !=
                      0 &&
                      (ioHandler.
                         registers[255] &
                         INT_VBLANK) !=
                      0) {
                    triggerInterrupt(
                      INT_VBLANK);
                    if ((ioHandler.
                           registers[65] &
                           16) !=
                          0 &&
                          (ioHandler.
                             registers[255] &
                             INT_LCDC) !=
                          0) {
                        triggerInterrupt(
                          INT_LCDC);
                    }
                }
                boolean speedThrottle =
                  true;
                if (!JavaBoy.
                       runningAsApplet) {
                    GameBoyScreen g =
                      (GameBoyScreen)
                        applet;
                    speedThrottle =
                      g.
                        viewSpeedThrottle.
                        getState(
                          );
                }
                if (speedThrottle &&
                      graphicsChip.
                        frameWaitTime >=
                      0) {
                    try {
                        java.lang.Thread.
                          sleep(
                            graphicsChip.
                              frameWaitTime);
                    }
                    catch (java.lang.InterruptedException e) {
                        
                    }
                }
            }
            graphicsChip.
              notifyScanline(
                JavaBoy.
                  unsign(
                    ioHandler.
                      registers[68]));
            ioHandler.
              registers[68] =
              (byte)
                (JavaBoy.
                   unsign(
                     ioHandler.
                       registers[68]) +
                   1);
            if (JavaBoy.
                  unsign(
                    ioHandler.
                      registers[68]) >=
                  153) {
                ioHandler.
                  registers[68] =
                  0;
                if (soundChip !=
                      null)
                    soundChip.
                      outputSound(
                        );
                graphicsChip.
                  frameDone =
                  false;
                if (JavaBoy.
                      runningAsApplet) {
                    ((JavaBoy)
                       applet).
                      drawNextFrame(
                        );
                }
                else {
                    ((GameBoyScreen)
                       applet).
                      repaint(
                        );
                }
                try {
                    while (!graphicsChip.
                              frameDone) {
                        java.lang.Thread.
                          sleep(
                            1);
                    }
                }
                catch (java.lang.InterruptedException e) {
                    
                }
            }
        }
    }
    public final void execute(int numInstr) {
        terminate =
          false;
        short newf;
        int dat;
        running =
          true;
        graphicsChip.
          startTime =
          java.lang.System.
            currentTimeMillis(
              );
        int b1;
        int b2;
        int b3;
        int offset;
        for (int r =
               0;
             r !=
               numInstr &&
               !terminate;
             r++) {
            instrCount++;
            b1 =
              JavaBoy.
                unsign(
                  addressRead(
                    pc));
            offset =
              addressRead(
                pc +
                  1);
            b3 =
              JavaBoy.
                unsign(
                  addressRead(
                    pc +
                      2));
            b2 =
              JavaBoy.
                unsign(
                  (short)
                    offset);
            switch (b1) {
                case 0:
                    pc++;
                    break;
                case 1:
                    pc +=
                      3;
                    b =
                      b3;
                    c =
                      b2;
                    break;
                case 2:
                    pc++;
                    addressWrite(
                      b <<
                        8 |
                        c,
                      a);
                    break;
                case 3:
                    pc++;
                    c++;
                    if (c ==
                          256) {
                        b++;
                        c =
                          0;
                        if (b ==
                              256) {
                            b =
                              0;
                        }
                    }
                    break;
                case 4:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (b) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            b =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            b =
                              16;
                            break;
                        default:
                            b++;
                            break;
                    }
                    break;
                case 5:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (b) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            b =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            b =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            b =
                              0;
                            break;
                        default:
                            b--;
                            break;
                    }
                    break;
                case 6:
                    pc +=
                      2;
                    b =
                      b2;
                    break;
                case 7:
                    pc++;
                    f =
                      0;
                    a <<=
                      1;
                    if ((a &
                           256) !=
                          0) {
                        f |=
                          F_CARRY;
                        a |=
                          1;
                        a &=
                          255;
                    }
                    if (a ==
                          0) {
                        f |=
                          F_ZERO;
                    }
                    break;
                case 8:
                    pc +=
                      3;
                    addressWrite(
                      (b3 <<
                         8) +
                        b2 +
                        1,
                      (sp &
                         65280) >>
                        8);
                    addressWrite(
                      (b3 <<
                         8) +
                        b2,
                      sp &
                        255);
                    break;
                case 9:
                    pc++;
                    hl =
                      hl +
                        ((b <<
                            8) +
                           c);
                    if ((hl &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 10:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            (b <<
                               8) +
                              c));
                    break;
                case 11:
                    pc++;
                    c--;
                    if ((c &
                           65280) !=
                          0) {
                        c =
                          255;
                        b--;
                        if ((b &
                               65280) !=
                              0) {
                            b =
                              255;
                        }
                    }
                    break;
                case 12:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (c) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            c =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            c =
                              16;
                            break;
                        default:
                            c++;
                            break;
                    }
                    break;
                case 13:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (c) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            c =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            c =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            c =
                              0;
                            break;
                        default:
                            c--;
                            break;
                    }
                    break;
                case 14:
                    pc +=
                      2;
                    c =
                      b2;
                    break;
                case 15:
                    pc++;
                    if ((a &
                           1) ==
                          1) {
                        f =
                          F_CARRY;
                    }
                    else {
                        f =
                          0;
                    }
                    a >>=
                      1;
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        a |=
                          128;
                    }
                    if (a ==
                          0) {
                        f |=
                          F_ZERO;
                    }
                    break;
                case 16:
                    pc +=
                      2;
                    if (gbcFeatures) {
                        if ((ioHandler.
                               registers[77] &
                               1) ==
                              1) {
                            int newKey1Reg =
                              ioHandler.
                                registers[77] &
                              254;
                            if ((newKey1Reg &
                                   128) ==
                                  128) {
                                setDoubleSpeedCpu(
                                  false);
                                newKey1Reg &=
                                  127;
                            }
                            else {
                                setDoubleSpeedCpu(
                                  true);
                                newKey1Reg |=
                                  128;
                            }
                            ioHandler.
                              registers[77] =
                              (byte)
                                newKey1Reg;
                        }
                    }
                    break;
                case 17:
                    pc +=
                      3;
                    d =
                      b3;
                    e =
                      b2;
                    break;
                case 18:
                    pc++;
                    addressWrite(
                      (d <<
                         8) +
                        e,
                      a);
                    break;
                case 19:
                    pc++;
                    e++;
                    if (e ==
                          256) {
                        d++;
                        e =
                          0;
                        if (d ==
                              256) {
                            d =
                              0;
                        }
                    }
                    break;
                case 20:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (d) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            d =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            d =
                              16;
                            break;
                        default:
                            d++;
                            break;
                    }
                    break;
                case 21:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (d) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            d =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            d =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            d =
                              0;
                            break;
                        default:
                            d--;
                            break;
                    }
                    break;
                case 22:
                    pc +=
                      2;
                    d =
                      b2;
                    break;
                case 23:
                    pc++;
                    if ((a &
                           128) ==
                          128) {
                        newf =
                          F_CARRY;
                    }
                    else {
                        newf =
                          0;
                    }
                    a <<=
                      1;
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        a |=
                          1;
                    }
                    a &=
                      255;
                    if (a ==
                          0) {
                        newf |=
                          F_ZERO;
                    }
                    f =
                      newf;
                    break;
                case 24:
                    pc +=
                      2 +
                        offset;
                    break;
                case 25:
                    pc++;
                    hl =
                      hl +
                        ((d <<
                            8) +
                           e);
                    if ((hl &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 26:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            (d <<
                               8) +
                              e));
                    break;
                case 27:
                    pc++;
                    e--;
                    if ((e &
                           65280) !=
                          0) {
                        e =
                          255;
                        d--;
                        if ((d &
                               65280) !=
                              0) {
                            d =
                              255;
                        }
                    }
                    break;
                case 28:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (e) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            e =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            e =
                              16;
                            break;
                        default:
                            e++;
                            break;
                    }
                    break;
                case 29:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (e) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            e =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            e =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            e =
                              0;
                            break;
                        default:
                            e--;
                            break;
                    }
                    break;
                case 30:
                    pc +=
                      2;
                    e =
                      b2;
                    break;
                case 31:
                    pc++;
                    if ((a &
                           1) ==
                          1) {
                        newf =
                          F_CARRY;
                    }
                    else {
                        newf =
                          0;
                    }
                    a >>=
                      1;
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        a |=
                          128;
                    }
                    if (a ==
                          0) {
                        newf |=
                          F_ZERO;
                    }
                    f =
                      newf;
                    break;
                case 32:
                    if ((f &
                           128) ==
                          0) {
                        pc +=
                          2 +
                            offset;
                    }
                    else {
                        pc +=
                          2;
                    }
                    break;
                case 33:
                    pc +=
                      3;
                    hl =
                      (b3 <<
                         8) +
                        b2;
                    break;
                case 34:
                    pc++;
                    addressWrite(
                      hl,
                      a);
                    hl =
                      hl +
                        1 &
                        65535;
                    break;
                case 35:
                    pc++;
                    hl =
                      hl +
                        1 &
                        65535;
                    break;
                case 36:
                    pc++;
                    f &=
                      F_CARRY;
                    switch ((hl &
                               65280) >>
                              8) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            hl =
                              hl &
                                255;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                255 |
                                16;
                            break;
                        default:
                            hl =
                              hl +
                                256;
                            break;
                    }
                    break;
                case 37:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch ((hl &
                               65280) >>
                              8) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                255 |
                                65280;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                255 |
                                3840;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            hl =
                              hl &
                                255;
                            break;
                        default:
                            hl =
                              hl &
                                255 |
                                (hl &
                                   65280) -
                                256;
                            break;
                    }
                    break;
                case 38:
                    pc +=
                      2;
                    hl =
                      hl &
                        255 |
                        b2 <<
                        8;
                    break;
                case 39:
                    pc++;
                    int upperNibble =
                      (a &
                         240) >>
                      4;
                    int lowerNibble =
                      a &
                      15;
                    newf =
                      (short)
                        (f &
                           F_SUBTRACT);
                    if ((f &
                           F_SUBTRACT) ==
                          0) {
                        if ((f &
                               F_CARRY) ==
                              0) {
                            if (upperNibble <=
                                  8 &&
                                  lowerNibble >=
                                  10 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  6;
                            }
                            if (upperNibble <=
                                  9 &&
                                  lowerNibble <=
                                  3 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  6;
                            }
                            if (upperNibble >=
                                  10 &&
                                  lowerNibble <=
                                  9 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  96;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble >=
                                  9 &&
                                  lowerNibble >=
                                  10 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  102;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble >=
                                  10 &&
                                  lowerNibble <=
                                  3 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  102;
                                newf |=
                                  F_CARRY;
                            }
                        }
                        else {
                            if (upperNibble <=
                                  2 &&
                                  lowerNibble <=
                                  9 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  96;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble <=
                                  2 &&
                                  lowerNibble >=
                                  10 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  102;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble <=
                                  3 &&
                                  lowerNibble <=
                                  3 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  102;
                                newf |=
                                  F_CARRY;
                            }
                        }
                    }
                    else {
                        if ((f &
                               F_CARRY) ==
                              0) {
                            if (upperNibble <=
                                  8 &&
                                  lowerNibble >=
                                  6 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  250;
                            }
                        }
                        else {
                            if (upperNibble >=
                                  7 &&
                                  lowerNibble <=
                                  9 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  0) {
                                a +=
                                  160;
                                newf |=
                                  F_CARRY;
                            }
                            if (upperNibble >=
                                  6 &&
                                  lowerNibble >=
                                  6 &&
                                  (f &
                                     F_HALFCARRY) ==
                                  F_HALFCARRY) {
                                a +=
                                  154;
                                newf |=
                                  F_CARRY;
                            }
                        }
                    }
                    a &=
                      255;
                    if (a ==
                          0)
                        newf |=
                          F_ZERO;
                    f =
                      newf;
                    break;
                case 40:
                    if ((f &
                           F_ZERO) ==
                          F_ZERO) {
                        pc +=
                          2 +
                            offset;
                    }
                    else {
                        pc +=
                          2;
                    }
                    break;
                case 41:
                    pc++;
                    hl =
                      hl +
                        hl;
                    if ((hl &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 42:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            hl));
                    hl++;
                    break;
                case 43:
                    pc++;
                    if (hl ==
                          0) {
                        hl =
                          65535;
                    }
                    else {
                        hl--;
                    }
                    break;
                case 44:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (hl &
                              255) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            hl =
                              hl &
                                65280;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            hl++;
                            break;
                        default:
                            hl++;
                            break;
                    }
                    break;
                case 45:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (hl &
                              255) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                65280 |
                                255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            hl =
                              hl &
                                65280 |
                                15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            hl =
                              hl &
                                65280;
                            break;
                        default:
                            hl =
                              hl &
                                65280 |
                                (hl &
                                   255) -
                                1;
                            break;
                    }
                    break;
                case 46:
                    pc +=
                      2;
                    hl =
                      hl &
                        65280 |
                        b2;
                    break;
                case 47:
                    pc++;
                    short mask =
                      128;
                    a =
                      (short)
                        (~a &
                           255);
                    f =
                      (short)
                        (f &
                           (F_CARRY |
                              F_ZERO) |
                           F_SUBTRACT |
                           F_HALFCARRY);
                    break;
                case 48:
                    if ((f &
                           F_CARRY) ==
                          0) {
                        pc +=
                          2 +
                            offset;
                    }
                    else {
                        pc +=
                          2;
                    }
                    break;
                case 49:
                    pc +=
                      3;
                    sp =
                      (b3 <<
                         8) +
                        b2;
                    break;
                case 50:
                    pc++;
                    addressWrite(
                      hl,
                      a);
                    hl--;
                    break;
                case 51:
                    pc++;
                    sp =
                      sp +
                        1 &
                        65535;
                    break;
                case 52:
                    pc++;
                    f &=
                      F_CARRY;
                    dat =
                      JavaBoy.
                        unsign(
                          addressRead(
                            hl));
                    switch (dat) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            addressWrite(
                              hl,
                              0);
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            addressWrite(
                              hl,
                              16);
                            break;
                        default:
                            addressWrite(
                              hl,
                              dat +
                                1);
                            break;
                    }
                    break;
                case 53:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    dat =
                      JavaBoy.
                        unsign(
                          addressRead(
                            hl));
                    switch (dat) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            addressWrite(
                              hl,
                              255);
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            addressWrite(
                              hl,
                              15);
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            addressWrite(
                              hl,
                              0);
                            break;
                        default:
                            addressWrite(
                              hl,
                              dat -
                                1);
                            break;
                    }
                    break;
                case 54:
                    pc +=
                      2;
                    addressWrite(
                      hl,
                      b2);
                    break;
                case 55:
                    pc++;
                    f &=
                      F_ZERO;
                    f |=
                      F_CARRY;
                    break;
                case 56:
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        pc +=
                          2 +
                            offset;
                    }
                    else {
                        pc +=
                          2;
                    }
                    break;
                case 57:
                    pc++;
                    hl =
                      hl +
                        sp;
                    if ((hl &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 58:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            hl));
                    hl =
                      hl -
                        1 &
                        65535;
                    break;
                case 59:
                    pc++;
                    sp =
                      sp -
                        1 &
                        65535;
                    break;
                case 60:
                    pc++;
                    f &=
                      F_CARRY;
                    switch (a) {
                        case 255:
                            f |=
                              F_HALFCARRY +
                                F_ZERO;
                            a =
                              0;
                            break;
                        case 15:
                            f |=
                              F_HALFCARRY;
                            a =
                              16;
                            break;
                        default:
                            a++;
                            break;
                    }
                    break;
                case 61:
                    pc++;
                    f &=
                      F_CARRY;
                    f |=
                      F_SUBTRACT;
                    switch (a) {
                        case 0:
                            f |=
                              F_HALFCARRY;
                            a =
                              255;
                            break;
                        case 16:
                            f |=
                              F_HALFCARRY;
                            a =
                              15;
                            break;
                        case 1:
                            f |=
                              F_ZERO;
                            a =
                              0;
                            break;
                        default:
                            a--;
                            break;
                    }
                    break;
                case 62:
                    pc +=
                      2;
                    a =
                      b2;
                    break;
                case 63:
                    pc++;
                    if ((f &
                           F_CARRY) ==
                          0) {
                        f =
                          (short)
                            (f &
                               F_ZERO |
                               F_CARRY);
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_ZERO);
                    }
                    break;
                case 82:
                    if (breakpointEnable) {
                        terminate =
                          true;
                        java.lang.System.
                          out.
                          println(
                            "- Breakpoint reached");
                    }
                    else {
                        pc++;
                    }
                    break;
                case 118:
                    interruptsEnabled =
                      true;
                    while (ioHandler.
                             registers[15] ==
                             0) {
                        initiateInterrupts(
                          );
                        instrCount++;
                    }
                    pc++;
                    break;
                case 175:
                    pc++;
                    a =
                      0;
                    f =
                      128;
                    break;
                case 192:
                    if ((f &
                           F_ZERO) ==
                          0) {
                        pc =
                          (JavaBoy.
                             unsign(
                               addressRead(
                                 sp +
                                   1)) <<
                             8) +
                            JavaBoy.
                            unsign(
                              addressRead(
                                sp));
                        sp +=
                          2;
                    }
                    else {
                        pc++;
                    }
                    break;
                case 193:
                    pc++;
                    c =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    b =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp +
                              1));
                    sp +=
                      2;
                    break;
                case 194:
                    if ((f &
                           F_ZERO) ==
                          0) {
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 195:
                    pc =
                      (b3 <<
                         8) +
                        b2;
                    break;
                case 196:
                    if ((f &
                           F_ZERO) ==
                          0) {
                        pc +=
                          3;
                        sp -=
                          2;
                        addressWrite(
                          sp +
                            1,
                          pc >>
                            8);
                        addressWrite(
                          sp,
                          pc &
                            255);
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 197:
                    pc++;
                    sp -=
                      2;
                    sp &=
                      65535;
                    addressWrite(
                      sp,
                      c);
                    addressWrite(
                      sp +
                        1,
                      b);
                    break;
                case 198:
                    pc +=
                      2;
                    f =
                      0;
                    if (((a &
                            15) +
                           (b2 &
                              15) &
                           240) !=
                          0) {
                        f |=
                          F_HALFCARRY;
                    }
                    a +=
                      b2;
                    if ((a &
                           65280) !=
                          0) {
                        if (a ==
                              256) {
                            f |=
                              F_ZERO +
                                F_CARRY +
                                F_HALFCARRY;
                            a =
                              0;
                        }
                        else {
                            f |=
                              F_CARRY +
                                F_HALFCARRY;
                            a &=
                              255;
                        }
                    }
                    break;
                case 207:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      8;
                    break;
                case 200:
                    if ((f &
                           F_ZERO) ==
                          F_ZERO) {
                        pc =
                          (JavaBoy.
                             unsign(
                               addressRead(
                                 sp +
                                   1)) <<
                             8) +
                            JavaBoy.
                            unsign(
                              addressRead(
                                sp));
                        sp +=
                          2;
                    }
                    else {
                        pc++;
                    }
                    break;
                case 201:
                    pc =
                      (JavaBoy.
                         unsign(
                           addressRead(
                             sp +
                               1)) <<
                         8) +
                        JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    sp +=
                      2;
                    break;
                case 202:
                    if ((f &
                           F_ZERO) ==
                          F_ZERO) {
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 203:
                    pc +=
                      2;
                    int regNum =
                      b2 &
                      7;
                    int data =
                      registerRead(
                        regNum);
                    if ((b2 &
                           192) ==
                          0) {
                        switch (b2 &
                                  248) {
                            case 0:
                                if ((data &
                                       128) ==
                                      128) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data <<=
                                  1;
                                if ((f &
                                       F_CARRY) ==
                                      F_CARRY) {
                                    data |=
                                      1;
                                }
                                data &=
                                  255;
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 8:
                                if ((data &
                                       1) ==
                                      1) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data >>=
                                  1;
                                if ((f &
                                       F_CARRY) ==
                                      F_CARRY) {
                                    data |=
                                      128;
                                }
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 16:
                                if ((data &
                                       128) ==
                                      128) {
                                    newf =
                                      F_CARRY;
                                }
                                else {
                                    newf =
                                      0;
                                }
                                data <<=
                                  1;
                                if ((f &
                                       F_CARRY) ==
                                      F_CARRY) {
                                    data |=
                                      1;
                                }
                                data &=
                                  255;
                                if (data ==
                                      0) {
                                    newf |=
                                      F_ZERO;
                                }
                                f =
                                  newf;
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 24:
                                if ((data &
                                       1) ==
                                      1) {
                                    newf =
                                      F_CARRY;
                                }
                                else {
                                    newf =
                                      0;
                                }
                                data >>=
                                  1;
                                if ((f &
                                       F_CARRY) ==
                                      F_CARRY) {
                                    data |=
                                      128;
                                }
                                if (data ==
                                      0) {
                                    newf |=
                                      F_ZERO;
                                }
                                f =
                                  newf;
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 32:
                                if ((data &
                                       128) ==
                                      128) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data <<=
                                  1;
                                data &=
                                  255;
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 40:
                                short topBit =
                                  0;
                                topBit =
                                  (short)
                                    (data &
                                       128);
                                if ((data &
                                       1) ==
                                      1) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data >>=
                                  1;
                                data |=
                                  topBit;
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 48:
                                data =
                                  (short)
                                    ((data &
                                        15) <<
                                       4 |
                                       (data &
                                          240) >>
                                       4);
                                if (data ==
                                      0) {
                                    f =
                                      F_ZERO;
                                }
                                else {
                                    f =
                                      0;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                            case 56:
                                if ((data &
                                       1) ==
                                      1) {
                                    f =
                                      F_CARRY;
                                }
                                else {
                                    f =
                                      0;
                                }
                                data >>=
                                  1;
                                if (data ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                registerWrite(
                                  regNum,
                                  data);
                                break;
                        }
                    }
                    else {
                        int bitNumber =
                          (b2 &
                             56) >>
                          3;
                        if ((b2 &
                               192) ==
                              64) {
                            mask =
                              (short)
                                (1 <<
                                   bitNumber);
                            if ((data &
                                   mask) !=
                                  0) {
                                f =
                                  (short)
                                    (f &
                                       F_CARRY |
                                       F_HALFCARRY);
                            }
                            else {
                                f =
                                  (short)
                                    (f &
                                       F_CARRY |
                                       F_HALFCARRY +
                                       F_ZERO);
                            }
                        }
                        if ((b2 &
                               192) ==
                              128) {
                            mask =
                              (short)
                                (255 -
                                   (1 <<
                                      bitNumber));
                            data =
                              (short)
                                (data &
                                   mask);
                            registerWrite(
                              regNum,
                              data);
                        }
                        if ((b2 &
                               192) ==
                              192) {
                            mask =
                              (short)
                                (1 <<
                                   bitNumber);
                            data =
                              (short)
                                (data |
                                   mask);
                            registerWrite(
                              regNum,
                              data);
                        }
                    }
                    break;
                case 204:
                    if ((f &
                           F_ZERO) ==
                          F_ZERO) {
                        pc +=
                          3;
                        sp -=
                          2;
                        addressWrite(
                          sp +
                            1,
                          pc >>
                            8);
                        addressWrite(
                          sp,
                          pc &
                            255);
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 205:
                    pc +=
                      3;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      (b3 <<
                         8) +
                        b2;
                    break;
                case 206:
                    pc +=
                      2;
                    if ((f &
                           F_CARRY) !=
                          0) {
                        b2++;
                    }
                    f =
                      0;
                    if (((a &
                            15) +
                           (b2 &
                              15) &
                           240) !=
                          0) {
                        f |=
                          F_HALFCARRY;
                    }
                    a +=
                      b2;
                    if ((a &
                           65280) !=
                          0) {
                        if (a ==
                              256) {
                            f |=
                              F_ZERO +
                                F_CARRY +
                                F_HALFCARRY;
                            a =
                              0;
                        }
                        else {
                            f |=
                              F_CARRY +
                                F_HALFCARRY;
                            a &=
                              255;
                        }
                    }
                    break;
                case 199:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      0;
                    break;
                case 208:
                    if ((f &
                           F_CARRY) ==
                          0) {
                        pc =
                          (JavaBoy.
                             unsign(
                               addressRead(
                                 sp +
                                   1)) <<
                             8) +
                            JavaBoy.
                            unsign(
                              addressRead(
                                sp));
                        sp +=
                          2;
                    }
                    else {
                        pc++;
                    }
                    break;
                case 209:
                    pc++;
                    e =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    d =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp +
                              1));
                    sp +=
                      2;
                    break;
                case 210:
                    if ((f &
                           F_CARRY) ==
                          0) {
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 212:
                    if ((f &
                           F_CARRY) ==
                          0) {
                        pc +=
                          3;
                        sp -=
                          2;
                        addressWrite(
                          sp +
                            1,
                          pc >>
                            8);
                        addressWrite(
                          sp,
                          pc &
                            255);
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 213:
                    pc++;
                    sp -=
                      2;
                    sp &=
                      65535;
                    addressWrite(
                      sp,
                      e);
                    addressWrite(
                      sp +
                        1,
                      d);
                    break;
                case 214:
                    pc +=
                      2;
                    f =
                      F_SUBTRACT;
                    if (((a &
                            15) -
                           (b2 &
                              15) &
                           65520) !=
                          0) {
                        f |=
                          F_HALFCARRY;
                    }
                    a -=
                      b2;
                    if ((a &
                           65280) !=
                          0) {
                        a &=
                          255;
                        f |=
                          F_CARRY;
                    }
                    if (a ==
                          0) {
                        f |=
                          F_ZERO;
                    }
                    break;
                case 215:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      16;
                    break;
                case 216:
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        pc =
                          (JavaBoy.
                             unsign(
                               addressRead(
                                 sp +
                                   1)) <<
                             8) +
                            JavaBoy.
                            unsign(
                              addressRead(
                                sp));
                        sp +=
                          2;
                    }
                    else {
                        pc++;
                    }
                    break;
                case 217:
                    interruptsEnabled =
                      true;
                    inInterrupt =
                      false;
                    pc =
                      (JavaBoy.
                         unsign(
                           addressRead(
                             sp +
                               1)) <<
                         8) +
                        JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    sp +=
                      2;
                    break;
                case 218:
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 220:
                    if ((f &
                           F_CARRY) ==
                          F_CARRY) {
                        pc +=
                          3;
                        sp -=
                          2;
                        addressWrite(
                          sp +
                            1,
                          pc >>
                            8);
                        addressWrite(
                          sp,
                          pc &
                            255);
                        pc =
                          (b3 <<
                             8) +
                            b2;
                    }
                    else {
                        pc +=
                          3;
                    }
                    break;
                case 222:
                    pc +=
                      2;
                    if ((f &
                           F_CARRY) !=
                          0) {
                        b2++;
                    }
                    f =
                      F_SUBTRACT;
                    if (((a &
                            15) -
                           (b2 &
                              15) &
                           65520) !=
                          0) {
                        f |=
                          F_HALFCARRY;
                    }
                    a -=
                      b2;
                    if ((a &
                           65280) !=
                          0) {
                        a &=
                          255;
                        f |=
                          F_CARRY;
                    }
                    if (a ==
                          0) {
                        f |=
                          F_ZERO;
                    }
                    break;
                case 223:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      24;
                    break;
                case 224:
                    pc +=
                      2;
                    addressWrite(
                      65280 +
                        b2,
                      a);
                    break;
                case 225:
                    pc++;
                    hl =
                      (JavaBoy.
                         unsign(
                           addressRead(
                             sp +
                               1)) <<
                         8) +
                        JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    sp +=
                      2;
                    break;
                case 226:
                    pc++;
                    addressWrite(
                      65280 +
                        c,
                      a);
                    break;
                case 229:
                    pc++;
                    sp -=
                      2;
                    sp &=
                      65535;
                    addressWrite(
                      sp +
                        1,
                      hl >>
                        8);
                    addressWrite(
                      sp,
                      hl &
                        255);
                    break;
                case 230:
                    pc +=
                      2;
                    a &=
                      b2;
                    if (a ==
                          0) {
                        f =
                          F_ZERO;
                    }
                    else {
                        f =
                          0;
                    }
                    break;
                case 231:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      32;
                    break;
                case 232:
                    pc +=
                      2;
                    sp =
                      sp +
                        offset;
                    if ((sp &
                           -65536) !=
                          0) {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY |
                               F_CARRY);
                        sp &=
                          65535;
                    }
                    else {
                        f =
                          (short)
                            (f &
                               F_SUBTRACT +
                               F_ZERO +
                               F_HALFCARRY);
                    }
                    break;
                case 233:
                    pc++;
                    pc =
                      hl;
                    break;
                case 234:
                    pc +=
                      3;
                    addressWrite(
                      (b3 <<
                         8) +
                        b2,
                      a);
                    break;
                case 238:
                    pc +=
                      2;
                    a ^=
                      b2;
                    if (a ==
                          0) {
                        f =
                          F_ZERO;
                    }
                    else {
                        f =
                          0;
                    }
                    break;
                case 239:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      40;
                    break;
                case 240:
                    pc +=
                      2;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            65280 +
                              b2));
                    break;
                case 241:
                    pc++;
                    f =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp));
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            sp +
                              1));
                    sp +=
                      2;
                    break;
                case 242:
                    pc++;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            65280 +
                              c));
                    break;
                case 243:
                    pc++;
                    interruptsEnabled =
                      false;
                    break;
                case 245:
                    pc++;
                    sp -=
                      2;
                    sp &=
                      65535;
                    addressWrite(
                      sp,
                      f);
                    addressWrite(
                      sp +
                        1,
                      a);
                    break;
                case 246:
                    pc +=
                      2;
                    a |=
                      b2;
                    if (a ==
                          0) {
                        f =
                          F_ZERO;
                    }
                    else {
                        f =
                          0;
                    }
                    break;
                case 247:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      48;
                    break;
                case 248:
                    pc +=
                      2;
                    hl =
                      sp +
                        offset;
                    if ((hl &
                           65536) !=
                          0) {
                        f =
                          F_CARRY;
                        hl &=
                          65535;
                    }
                    else {
                        f =
                          0;
                    }
                    break;
                case 249:
                    pc++;
                    sp =
                      hl;
                    break;
                case 250:
                    pc +=
                      3;
                    a =
                      JavaBoy.
                        unsign(
                          addressRead(
                            (b3 <<
                               8) +
                              b2));
                    break;
                case 251:
                    pc++;
                    ieDelay =
                      1;
                    break;
                case 254:
                    pc +=
                      2;
                    f =
                      0;
                    if (b2 ==
                          a) {
                        f |=
                          F_ZERO;
                    }
                    else {
                        if (a <
                              b2) {
                            f |=
                              F_CARRY;
                        }
                    }
                    break;
                case 255:
                    pc++;
                    sp -=
                      2;
                    addressWrite(
                      sp +
                        1,
                      pc >>
                        8);
                    addressWrite(
                      sp,
                      pc &
                        255);
                    pc =
                      56;
                    break;
                default:
                    if ((b1 &
                           192) ==
                          128) {
                        pc++;
                        int operand =
                          registerRead(
                            b1 &
                              7);
                        switch ((b1 &
                                   56) >>
                                  3) {
                            case 1:
                                if ((f &
                                       F_CARRY) !=
                                      0) {
                                    operand++;
                                }
                            case 0:
                                f =
                                  0;
                                if (((a &
                                        15) +
                                       (operand &
                                          15) &
                                       240) !=
                                      0) {
                                    f |=
                                      F_HALFCARRY;
                                }
                                a +=
                                  operand;
                                if (a ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                if ((a &
                                       65280) !=
                                      0) {
                                    if (a ==
                                          256) {
                                        f |=
                                          F_ZERO +
                                            F_CARRY +
                                            F_HALFCARRY;
                                        a =
                                          0;
                                    }
                                    else {
                                        f |=
                                          F_CARRY +
                                            F_HALFCARRY;
                                        a &=
                                          255;
                                    }
                                }
                                break;
                            case 3:
                                if ((f &
                                       F_CARRY) !=
                                      0) {
                                    operand++;
                                }
                            case 2:
                                f =
                                  F_SUBTRACT;
                                if (((a &
                                        15) -
                                       (operand &
                                          15) &
                                       65520) !=
                                      0) {
                                    f |=
                                      F_HALFCARRY;
                                }
                                a -=
                                  operand;
                                if ((a &
                                       65280) !=
                                      0) {
                                    a &=
                                      255;
                                    f |=
                                      F_CARRY;
                                }
                                if (a ==
                                      0) {
                                    f |=
                                      F_ZERO;
                                }
                                break;
                            case 4:
                                a &=
                                  operand;
                                if (a ==
                                      0) {
                                    f =
                                      F_ZERO;
                                }
                                else {
                                    f =
                                      0;
                                }
                                break;
                            case 5:
                                a ^=
                                  operand;
                                if (a ==
                                      0) {
                                    f =
                                      F_ZERO;
                                }
                                else {
                                    f =
                                      0;
                                }
                                break;
                            case 6:
                                a |=
                                  operand;
                                if (a ==
                                      0) {
                                    f =
                                      F_ZERO;
                                }
                                else {
                                    f =
                                      0;
                                }
                                break;
                            case 7:
                                f =
                                  F_SUBTRACT;
                                if (a ==
                                      operand) {
                                    f |=
                                      F_ZERO;
                                }
                                if (a <
                                      operand) {
                                    f |=
                                      F_CARRY;
                                }
                                if ((a &
                                       15) <
                                      (operand &
                                         15)) {
                                    f |=
                                      F_HALFCARRY;
                                }
                                break;
                        }
                    }
                    else
                        if ((b1 &
                               192) ==
                              64) {
                            pc++;
                            registerWrite(
                              (b1 &
                                 56) >>
                                3,
                              registerRead(
                                b1 &
                                  7));
                        }
                        else {
                            java.lang.System.
                              out.
                              println(
                                "Unrecognized opcode (" +
                                JavaBoy.
                                  hexByte(
                                    b1) +
                                ")");
                            terminate =
                              true;
                            pc++;
                            break;
                        }
            }
            if (ieDelay !=
                  -1) {
                if (ieDelay >
                      0) {
                    ieDelay--;
                }
                else {
                    interruptsEnabled =
                      true;
                    ieDelay =
                      -1;
                }
            }
            if (interruptsEnabled) {
                checkInterrupts(
                  );
            }
            cartridge.
              update(
                );
            initiateInterrupts(
              );
        }
        running =
          false;
        terminate =
          false;
    }
    public void setBreakpoint(boolean on) {
        breakpointEnable =
          on;
    }
    public java.lang.String disassemble(int address,
                                        int numInstr) {
        java.lang.System.
          out.
          println(
            "Addr  Data      Instruction");
        for (int r =
               0;
             r <
               numInstr;
             r++) {
            short b1 =
              JavaBoy.
              unsign(
                addressRead(
                  address));
            short offset =
              addressRead(
                address +
                  1);
            short b3 =
              JavaBoy.
              unsign(
                addressRead(
                  address +
                    2));
            short b2 =
              JavaBoy.
              unsign(
                offset);
            java.lang.String instr =
              new java.lang.String(
              "Unknown Opcode! (" +
              java.lang.Integer.
                toHexString(
                  JavaBoy.
                    unsign(
                      b1)) +
              ")");
            byte instrLength =
              1;
            switch (b1) {
                case 0:
                    instr =
                      "NOP";
                    break;
                case 1:
                    instr =
                      "LD BC, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 2:
                    instr =
                      "LD (BC), A";
                    break;
                case 3:
                    instr =
                      "INC BC";
                    break;
                case 4:
                    instr =
                      "INC B";
                    break;
                case 5:
                    instr =
                      "DEC B";
                    break;
                case 6:
                    instr =
                      "LD B, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 7:
                    instr =
                      "RLC A";
                    break;
                case 8:
                    instr =
                      "LD (" +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2) +
                      "), SP";
                    instrLength =
                      3;
                    break;
                case 9:
                    instr =
                      "ADD HL, BC";
                    break;
                case 10:
                    instr =
                      "LD A, (BC)";
                    break;
                case 11:
                    instr =
                      "DEC BC";
                    break;
                case 12:
                    instr =
                      "INC C";
                    break;
                case 13:
                    instr =
                      "DEC C";
                    break;
                case 14:
                    instr =
                      "LD C, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 15:
                    instr =
                      "RRC A";
                    break;
                case 16:
                    instr =
                      "STOP";
                    instrLength =
                      2;
                    break;
                case 17:
                    instr =
                      "LD DE, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 18:
                    instr =
                      "LD (DE), A";
                    break;
                case 19:
                    instr =
                      "INC DE";
                    break;
                case 20:
                    instr =
                      "INC D";
                    break;
                case 21:
                    instr =
                      "DEC D";
                    break;
                case 22:
                    instr =
                      "LD D, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 23:
                    instr =
                      "RL A";
                    break;
                case 24:
                    instr =
                      "JR " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset);
                    instrLength =
                      2;
                    break;
                case 25:
                    instr =
                      "ADD HL, DE";
                    break;
                case 26:
                    instr =
                      "LD A, (DE)";
                    break;
                case 27:
                    instr =
                      "DEC DE";
                    break;
                case 28:
                    instr =
                      "INC E";
                    break;
                case 29:
                    instr =
                      "DEC E";
                    break;
                case 30:
                    instr =
                      "LD E, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 31:
                    instr =
                      "RR A";
                    break;
                case 32:
                    instr =
                      "JR NZ, " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset) +
                      ": " +
                      offset;
                    instrLength =
                      2;
                    break;
                case 33:
                    instr =
                      "LD HL, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 34:
                    instr =
                      "LD (HL+), A";
                    break;
                case 35:
                    instr =
                      "INC HL";
                    break;
                case 36:
                    instr =
                      "INC H";
                    break;
                case 37:
                    instr =
                      "DEC H";
                    break;
                case 38:
                    instr =
                      "LD H, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 39:
                    instr =
                      "DAA";
                    break;
                case 40:
                    instr =
                      "JR Z, " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset);
                    instrLength =
                      2;
                    break;
                case 41:
                    instr =
                      "ADD HL, HL";
                    break;
                case 42:
                    instr =
                      "LDI A, (HL)";
                    break;
                case 43:
                    instr =
                      "DEC HL";
                    break;
                case 44:
                    instr =
                      "INC L";
                    break;
                case 45:
                    instr =
                      "DEC L";
                    break;
                case 46:
                    instr =
                      "LD L, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 47:
                    instr =
                      "CPL";
                    break;
                case 48:
                    instr =
                      "JR NC, " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset);
                    instrLength =
                      2;
                    break;
                case 49:
                    instr =
                      "LD SP, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 50:
                    instr =
                      "LD (HL-), A";
                    break;
                case 51:
                    instr =
                      "INC SP";
                    break;
                case 52:
                    instr =
                      "INC (HL)";
                    break;
                case 53:
                    instr =
                      "DEC (HL)";
                    break;
                case 54:
                    instr =
                      "LD (HL), " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 55:
                    instr =
                      "SCF";
                    break;
                case 56:
                    instr =
                      "JR C, " +
                      JavaBoy.
                        hexWord(
                          address +
                            2 +
                            offset);
                    instrLength =
                      2;
                    break;
                case 57:
                    instr =
                      "ADD HL, SP";
                    break;
                case 58:
                    instr =
                      "LD A, (HL-)";
                    break;
                case 59:
                    instr =
                      "DEC SP";
                    break;
                case 60:
                    instr =
                      "INC A";
                    break;
                case 61:
                    instr =
                      "DEC A";
                    break;
                case 62:
                    instr =
                      "LD A, " +
                      JavaBoy.
                        hexByte(
                          JavaBoy.
                            unsign(
                              b2));
                    instrLength =
                      2;
                    break;
                case 63:
                    instr =
                      "CCF";
                    break;
                case 118:
                    instr =
                      "HALT";
                    break;
                case 192:
                    instr =
                      "RET NZ";
                    break;
                case 193:
                    instr =
                      "POP BC";
                    break;
                case 194:
                    instr =
                      "JP NZ, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 195:
                    instr =
                      "JP " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 196:
                    instr =
                      "CALL NZ, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 197:
                    instr =
                      "PUSH BC";
                    break;
                case 198:
                    instr =
                      "ADD A, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 199:
                    instr =
                      "RST 00";
                    break;
                case 200:
                    instr =
                      "RET Z";
                    break;
                case 201:
                    instr =
                      "RET";
                    break;
                case 202:
                    instr =
                      "JP Z, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 204:
                    instr =
                      "CALL Z, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 205:
                    instr =
                      "CALL " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 206:
                    instr =
                      "ADC A, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 207:
                    instr =
                      "RST 08";
                    break;
                case 208:
                    instr =
                      "RET NC";
                    break;
                case 209:
                    instr =
                      "POP DE";
                    break;
                case 210:
                    instr =
                      "JP NC, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 212:
                    instr =
                      "CALL NC, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 213:
                    instr =
                      "PUSH DE";
                    break;
                case 214:
                    instr =
                      "SUB A, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 215:
                    instr =
                      "RST 10";
                    break;
                case 216:
                    instr =
                      "RET C";
                    break;
                case 217:
                    instr =
                      "RETI";
                    break;
                case 218:
                    instr =
                      "JP C, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 220:
                    instr =
                      "CALL C, " +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2);
                    instrLength =
                      3;
                    break;
                case 222:
                    instr =
                      "SBC A, " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 223:
                    instr =
                      "RST 18";
                    break;
                case 224:
                    instr =
                      "LDH (FF" +
                      JavaBoy.
                        hexByte(
                          b2 &
                            255) +
                      "), A";
                    instrLength =
                      2;
                    break;
                case 225:
                    instr =
                      "POP HL";
                    break;
                case 226:
                    instr =
                      "LDH (FF00 + C), A";
                    break;
                case 229:
                    instr =
                      "PUSH HL";
                    break;
                case 230:
                    instr =
                      "AND " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 231:
                    instr =
                      "RST 20";
                    break;
                case 232:
                    instr =
                      "ADD SP, " +
                      JavaBoy.
                        hexByte(
                          offset);
                    instrLength =
                      2;
                    break;
                case 233:
                    instr =
                      "JP (HL)";
                    break;
                case 234:
                    instr =
                      "LD (" +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2) +
                      "), A";
                    instrLength =
                      3;
                    break;
                case 238:
                    instr =
                      "XOR " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 239:
                    instr =
                      "RST 28";
                    break;
                case 240:
                    instr =
                      "LDH A, (FF" +
                      JavaBoy.
                        hexByte(
                          b2) +
                      ")";
                    instrLength =
                      2;
                    break;
                case 241:
                    instr =
                      "POP AF";
                    break;
                case 242:
                    instr =
                      "LD A, (FF00 + C)";
                    break;
                case 243:
                    instr =
                      "DI";
                    break;
                case 245:
                    instr =
                      "PUSH AF";
                    break;
                case 246:
                    instr =
                      "OR " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 247:
                    instr =
                      "RST 30";
                    break;
                case 248:
                    instr =
                      "LD HL, SP + " +
                      JavaBoy.
                        hexByte(
                          offset);
                    instrLength =
                      2;
                    break;
                case 249:
                    instr =
                      "LD SP, HL";
                    break;
                case 250:
                    instr =
                      "LD A, (" +
                      JavaBoy.
                        hexWord(
                          (b3 <<
                             8) +
                            b2) +
                      ")";
                    instrLength =
                      3;
                    break;
                case 251:
                    instr =
                      "EI";
                    break;
                case 254:
                    instr =
                      "CP " +
                      JavaBoy.
                        hexByte(
                          b2);
                    instrLength =
                      2;
                    break;
                case 255:
                    instr =
                      "RST 38";
                    break;
            }
            if (JavaBoy.
                  unsign(
                    b1) >=
                  64 &&
                  JavaBoy.
                  unsign(
                    b1) <=
                  127 &&
                  JavaBoy.
                  unsign(
                    b1) !=
                  118) {
                int sourceRegister =
                  b1 &
                  7;
                int destRegister =
                  (b1 &
                     56) >>
                  3;
                instr =
                  "LD " +
                  registerNames[destRegister] +
                  ", " +
                  registerNames[sourceRegister];
            }
            if (JavaBoy.
                  unsign(
                    b1) >=
                  128 &&
                  JavaBoy.
                  unsign(
                    b1) <=
                  191) {
                int sourceRegister =
                  JavaBoy.
                  unsign(
                    b1) &
                  7;
                int operation =
                  (JavaBoy.
                     unsign(
                       b1) &
                     56) >>
                  3;
                instr =
                  aluOperations[operation] +
                  " A, " +
                  registerNames[sourceRegister];
            }
            if (JavaBoy.
                  unsign(
                    b1) ==
                  203) {
                int operation;
                int sourceRegister;
                int bitNumber;
                instrLength =
                  2;
                switch ((JavaBoy.
                           unsign(
                             b2) &
                           192) >>
                          6) {
                    case 0:
                        operation =
                          (JavaBoy.
                             unsign(
                               b2) &
                             56) >>
                            3;
                        sourceRegister =
                          JavaBoy.
                            unsign(
                              b2) &
                            7;
                        instr =
                          shiftOperations[operation] +
                          " " +
                          registerNames[sourceRegister];
                        break;
                    case 1:
                        bitNumber =
                          (JavaBoy.
                             unsign(
                               b2) &
                             56) >>
                            3;
                        sourceRegister =
                          JavaBoy.
                            unsign(
                              b2) &
                            7;
                        instr =
                          "BIT " +
                          bitNumber +
                          ", " +
                          registerNames[sourceRegister];
                        break;
                    case 2:
                        bitNumber =
                          (JavaBoy.
                             unsign(
                               b2) &
                             56) >>
                            3;
                        sourceRegister =
                          JavaBoy.
                            unsign(
                              b2) &
                            7;
                        instr =
                          "RES " +
                          bitNumber +
                          ", " +
                          registerNames[sourceRegister];
                        break;
                    case 3:
                        bitNumber =
                          (JavaBoy.
                             unsign(
                               b2) &
                             56) >>
                            3;
                        sourceRegister =
                          JavaBoy.
                            unsign(
                              b2) &
                            7;
                        instr =
                          "SET " +
                          bitNumber +
                          ", " +
                          registerNames[sourceRegister];
                        break;
                }
            }
            java.lang.System.
              out.
              print(
                JavaBoy.
                  hexWord(
                    address) +
                ": " +
                JavaBoy.
                  hexByte(
                    JavaBoy.
                      unsign(
                        b1)));
            if (instrLength >=
                  2) {
                java.lang.System.
                  out.
                  print(
                    " " +
                    JavaBoy.
                      hexByte(
                        JavaBoy.
                          unsign(
                            b2)));
            }
            else {
                java.lang.System.
                  out.
                  print(
                    "   ");
            }
            if (instrLength ==
                  3) {
                java.lang.System.
                  out.
                  print(
                    " " +
                    JavaBoy.
                      hexByte(
                        JavaBoy.
                          unsign(
                            b3)) +
                    "  ");
            }
            else {
                java.lang.System.
                  out.
                  print(
                    "     ");
            }
            java.lang.System.
              out.
              println(
                instr);
            address +=
              instrLength;
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "U0lrB7gIG7Y0cdWWp/d9Nyp158DDkj1/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "naewe3eWCRt2dfIIu/GtYPeJLbtPvEDs9FPYzbNM2bBrdY+wU58Hu/WD1Y8A" +
       "HJ/asvvUOdidezAJT6EYZ5kL3Ove2zF7owl7wNS7Fe71c1umn7uFTI93r+89" +
       "he77s+ypQy8DHTecfN+t0Nsvbfl+6dbo7WESP3zKtWez7Jkwd5+ia4q5eX29" +
       "KStHGJ75nYuzGIJoaOerW4ZfvfUMP37Ktexpw90fA0YJhsf146yHiT33fIlB" +
       "AOPfbIn9za0hdsgeP7Fm8OlT2P10ln0KTJYyh+pGoPd4T9NUwouOMD3zsxZn" +
       "GeVjANM/bpn+4y00ysNsfv6Ua7+QZT8LIp21pu5/BCI4wvPMR6XP4vldAPKj" +
       "m7qb/7eI53Vu9tdOIfuFLPvlbIbiG7OZ5h/+5sVhtr9yC1zt7uNbto+/kGx/" +
       "+xS2v5NlvxHmXnmULTU9+CjKYdpfer603wgYXNnSvvICKfMfnnLtj7Ls34e5" +
       "BwzHCA0wAT1Rn3/v+VIFvbr7sS3Vj72QPfyNU/hmKzu7/ynMXdBSTYmuG0H/" +
       "8/N1w28A/0ebupv/N0jyPG74r07h9z+y7M9BnJBF7ftfgznC8pvPg+XF7ORD" +
       "gN07tyzfeWtYHh8S/f0pVP8hy/4nmISpRiAFgWZvPniz8+QB0f91HqLp/ud1" +
       "vf0Xhw69OLz5ZmO6eS3vFYeEs1n+e+CsWx1au3v0mhd415/13nvZNtp82Puq" +
       "8vlPtpmnvl3+qc0HYRVLWq2yVu7q5i5svk27bjR7Yfe1J7a219adrTd9576f" +
       "v/v1e6uB920AH3TUIWyvOf7rq6Tthevvpa5+5eW/+Naf+eTX1t/s+f/JJBxR" +
       "b10AAA==");
}
