class IoHandler {
    byte[] registers = new byte[256];
    Dmgcpu dmgcpu;
    boolean padLeft;
    boolean padRight;
    boolean padUp;
    boolean padDown;
    boolean padA;
    boolean padB;
    boolean padStart;
    boolean padSelect;
    boolean hdmaRunning;
    public IoHandler(Dmgcpu d) { super();
                                 dmgcpu = d;
                                 reset(); }
    public void reset() { java.lang.System.out.println("Hardware reset");
                          for (int r = 0; r < 255; r++) { ioWrite(r, (short)
                                                                       0);
                          }
                          ioWrite(64, (short) 145);
                          ioWrite(15, (short) 1);
                          hdmaRunning = false; }
    public void toggleKey(java.lang.String keyName) { if (keyName.equals(
                                                                    "a")) {
                                                          padA =
                                                            !padA;
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "- A is now " +
                                                              padA);
                                                      }
                                                      else
                                                          if (keyName.
                                                                equals(
                                                                  "b")) {
                                                              padB =
                                                                !padB;
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "- B is now " +
                                                                  padB);
                                                          }
                                                          else
                                                              if (keyName.
                                                                    equals(
                                                                      "up")) {
                                                                  padUp =
                                                                    !padUp;
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      "- Up is now " +
                                                                      padUp);
                                                              }
                                                              else
                                                                  if (keyName.
                                                                        equals(
                                                                          "down")) {
                                                                      padDown =
                                                                        !padDown;
                                                                      java.lang.System.
                                                                        out.
                                                                        println(
                                                                          "- Down is now " +
                                                                          padDown);
                                                                  }
                                                                  else
                                                                      if (keyName.
                                                                            equals(
                                                                              "left")) {
                                                                          padLeft =
                                                                            !padLeft;
                                                                          java.lang.System.
                                                                            out.
                                                                            println(
                                                                              "- Left is now " +
                                                                              padLeft);
                                                                      }
                                                                      else
                                                                          if (keyName.
                                                                                equals(
                                                                                  "right")) {
                                                                              padRight =
                                                                                !padRight;
                                                                              java.lang.System.
                                                                                out.
                                                                                println(
                                                                                  "- Right is now " +
                                                                                  padRight);
                                                                          }
                                                                          else
                                                                              if (keyName.
                                                                                    equals(
                                                                                      "select")) {
                                                                                  padSelect =
                                                                                    !padSelect;
                                                                                  java.lang.System.
                                                                                    out.
                                                                                    println(
                                                                                      "- Select is now " +
                                                                                      padSelect);
                                                                              }
                                                                              else
                                                                                  if (keyName.
                                                                                        equals(
                                                                                          "start")) {
                                                                                      padStart =
                                                                                        !padStart;
                                                                                      java.lang.System.
                                                                                        out.
                                                                                        println(
                                                                                          "- Start is now " +
                                                                                          padStart);
                                                                                  }
                                                                                  else {
                                                                                      java.lang.System.
                                                                                        out.
                                                                                        println(
                                                                                          "- Key name \'" +
                                                                                          keyName +
                                                                                          "\' not recognised");
                                                                                  }
    }
    public void performHdma() { int dmaSrc =
                                  (JavaBoy.
                                     unsign(
                                       registers[81]) <<
                                     8) +
                                  (JavaBoy.
                                     unsign(
                                       registers[82]) &
                                     240);
                                int dmaDst =
                                  ((JavaBoy.
                                      unsign(
                                        registers[83]) &
                                      31) <<
                                     8) +
                                  (JavaBoy.
                                     unsign(
                                       registers[84]) &
                                     240) +
                                  32768;
                                for (int r =
                                       0;
                                     r <
                                       16;
                                     r++) {
                                    dmgcpu.
                                      addressWrite(
                                        dmaDst +
                                          r,
                                        dmgcpu.
                                          addressRead(
                                            dmaSrc +
                                              r));
                                }
                                dmaSrc +=
                                  16;
                                dmaDst +=
                                  16;
                                registers[81] =
                                  (byte)
                                    ((dmaSrc &
                                        65280) >>
                                       8);
                                registers[82] =
                                  (byte)
                                    (dmaSrc &
                                       240);
                                registers[83] =
                                  (byte)
                                    ((dmaDst &
                                        7936) >>
                                       8);
                                registers[84] =
                                  (byte)
                                    (dmaDst &
                                       240);
                                int len =
                                  JavaBoy.
                                  unsign(
                                    registers[85]);
                                if (len ==
                                      0) {
                                    registers[85] =
                                      (byte)
                                        255;
                                    hdmaRunning =
                                      false;
                                }
                                else {
                                    len--;
                                    registers[85] =
                                      (byte)
                                        len;
                                } }
    public short ioRead(int num) { if (num <=
                                         75) {
                                       
                                   }
                                   switch (num) {
                                       case 65:
                                           int output =
                                             0;
                                           if (registers[68] ==
                                                 registers[69]) {
                                               output |=
                                                 4;
                                           }
                                           int cyclePos =
                                             dmgcpu.
                                               instrCount %
                                             dmgcpu.
                                               INSTRS_PER_HBLANK;
                                           int sectionLength =
                                             dmgcpu.
                                               INSTRS_PER_HBLANK /
                                             6;
                                           if (JavaBoy.
                                                 unsign(
                                                   registers[68]) >
                                                 144) {
                                               output |=
                                                 1;
                                           }
                                           else {
                                               if (cyclePos <=
                                                     sectionLength *
                                                     3) {
                                                   
                                               }
                                               else
                                                   if (cyclePos <=
                                                         sectionLength *
                                                         4) {
                                                       output |=
                                                         2;
                                                   }
                                                   else {
                                                       output |=
                                                         3;
                                                   }
                                           }
                                           return (byte)
                                                    (output |
                                                       registers[65] &
                                                       248);
                                       case 85:
                                           return (byte)
                                                    registers[85];
                                       case 105:
                                           if (dmgcpu.
                                                 gbcFeatures) {
                                               int palNumber =
                                                 (registers[104] &
                                                    56) >>
                                                 3;
                                               return dmgcpu.
                                                        graphicsChip.
                                                        gbcBackground[palNumber].
                                                 getGbcColours(
                                                   (JavaBoy.
                                                      unsign(
                                                        registers[104]) &
                                                      6) >>
                                                     1,
                                                   (JavaBoy.
                                                      unsign(
                                                        registers[104]) &
                                                      1) ==
                                                     1);
                                           }
                                           else {
                                               return registers[num];
                                           }
                                       case 107:
                                           if (dmgcpu.
                                                 gbcFeatures) {
                                               int palNumber =
                                                 (registers[106] &
                                                    56) >>
                                                 3;
                                               return dmgcpu.
                                                        graphicsChip.
                                                        gbcSprite[palNumber].
                                                 getGbcColours(
                                                   (JavaBoy.
                                                      unsign(
                                                        registers[106]) &
                                                      6) >>
                                                     1,
                                                   (JavaBoy.
                                                      unsign(
                                                        registers[106]) &
                                                      1) ==
                                                     1);
                                           }
                                           else {
                                               return registers[num];
                                           }
                                       default:
                                           return registers[num];
                                   } }
    public void ioWrite(int num, short data) {
        boolean soundOn =
          dmgcpu.
            soundChip !=
          null;
        if (num <=
              75) {
            
        }
        switch (num) {
            case 0:
                short output =
                  15;
                if ((data &
                       16) ==
                      0) {
                    if (padRight) {
                        output &=
                          ~1;
                    }
                    if (padLeft) {
                        output &=
                          ~2;
                    }
                    if (padUp) {
                        output &=
                          ~4;
                    }
                    if (padDown) {
                        output &=
                          ~8;
                    }
                }
                if ((data &
                       32) ==
                      0) {
                    if (padA) {
                        output &=
                          ~1;
                    }
                    if (padB) {
                        output &=
                          ~2;
                    }
                    if (padSelect) {
                        output &=
                          ~4;
                    }
                    if (padStart) {
                        output &=
                          ~8;
                    }
                }
                output |=
                  data &
                    240;
                registers[0] =
                  (byte)
                    output;
                break;
            case 2:
                registers[2] =
                  (byte)
                    data;
                if (dmgcpu.
                      gameLink !=
                      null) {
                    if ((JavaBoy.
                           unsign(
                             data) &
                           129) ==
                          129) {
                        dmgcpu.
                          gameLink.
                          send(
                            registers[1]);
                    }
                }
                else {
                    if ((registers[2] &
                           1) ==
                          1) {
                        registers[1] =
                          (byte)
                            255;
                        if (dmgcpu.
                              running)
                            dmgcpu.
                              triggerInterruptIfEnabled(
                                dmgcpu.
                                  INT_SER);
                        registers[2] &=
                          127;
                    }
                }
                break;
            case 4:
                registers[4] =
                  0;
                break;
            case 7:
                if ((data &
                       4) ==
                      0) {
                    dmgcpu.
                      timaEnabled =
                      false;
                }
                else {
                    dmgcpu.
                      timaEnabled =
                      true;
                }
                int instrsPerSecond =
                  dmgcpu.
                    INSTRS_PER_VBLANK *
                  60;
                int clockFrequency =
                  data &
                  3;
                switch (clockFrequency) {
                    case 0:
                        dmgcpu.
                          instrsPerTima =
                          instrsPerSecond /
                            4096;
                        break;
                    case 1:
                        dmgcpu.
                          instrsPerTima =
                          instrsPerSecond /
                            262144;
                        break;
                    case 2:
                        dmgcpu.
                          instrsPerTima =
                          instrsPerSecond /
                            65536;
                        break;
                    case 3:
                        dmgcpu.
                          instrsPerTima =
                          instrsPerSecond /
                            16384;
                        break;
                }
                break;
            case 16:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel1.
                      setSweep(
                        (JavaBoy.
                           unsign(
                             data) &
                           112) >>
                          4,
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          1);
                registers[16] =
                  (byte)
                    data;
                break;
            case 17:
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel1.
                      setDutyCycle(
                        (JavaBoy.
                           unsign(
                             data) &
                           192) >>
                          6);
                    dmgcpu.
                      soundChip.
                      channel1.
                      setLength(
                        JavaBoy.
                          unsign(
                            data) &
                          63);
                }
                registers[17] =
                  (byte)
                    data;
                break;
            case 18:
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel1.
                      setEnvelope(
                        (JavaBoy.
                           unsign(
                             data) &
                           240) >>
                          4,
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          8);
                }
                registers[18] =
                  (byte)
                    data;
                break;
            case 19:
                registers[19] =
                  (byte)
                    data;
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel1.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[20]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[19]));
                }
                break;
            case 20:
                registers[20] =
                  (byte)
                    data;
                if (soundOn) {
                    if ((registers[20] &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel1.
                          setLength(
                            JavaBoy.
                              unsign(
                                registers[17]) &
                              63);
                        dmgcpu.
                          soundChip.
                          channel1.
                          setEnvelope(
                            (JavaBoy.
                               unsign(
                                 registers[18]) &
                               240) >>
                              4,
                            JavaBoy.
                              unsign(
                                registers[18]) &
                              7,
                            (JavaBoy.
                               unsign(
                                 registers[18]) &
                               8) ==
                              8);
                    }
                    if ((registers[20] &
                           64) ==
                          0) {
                        dmgcpu.
                          soundChip.
                          channel1.
                          setLength(
                            -1);
                    }
                    dmgcpu.
                      soundChip.
                      channel1.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[20]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[19]));
                }
                break;
            case 23:
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel2.
                      setEnvelope(
                        (JavaBoy.
                           unsign(
                             data) &
                           240) >>
                          4,
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          8);
                }
                registers[23] =
                  (byte)
                    data;
                break;
            case 24:
                registers[24] =
                  (byte)
                    data;
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel2.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[25]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[24]));
                }
                break;
            case 25:
                registers[25] =
                  (byte)
                    data;
                if (soundOn) {
                    if ((registers[25] &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel2.
                          setLength(
                            JavaBoy.
                              unsign(
                                registers[33]) &
                              63);
                        dmgcpu.
                          soundChip.
                          channel2.
                          setEnvelope(
                            (JavaBoy.
                               unsign(
                                 registers[23]) &
                               240) >>
                              4,
                            JavaBoy.
                              unsign(
                                registers[23]) &
                              7,
                            (JavaBoy.
                               unsign(
                                 registers[23]) &
                               8) ==
                              8);
                    }
                    if ((registers[25] &
                           64) ==
                          0) {
                        dmgcpu.
                          soundChip.
                          channel2.
                          setLength(
                            -1);
                    }
                    dmgcpu.
                      soundChip.
                      channel2.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[25]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[24]));
                }
                break;
            case 22:
                if (soundOn) {
                    dmgcpu.
                      soundChip.
                      channel2.
                      setDutyCycle(
                        (JavaBoy.
                           unsign(
                             data) &
                           192) >>
                          6);
                    dmgcpu.
                      soundChip.
                      channel2.
                      setLength(
                        JavaBoy.
                          unsign(
                            data) &
                          63);
                }
                registers[22] =
                  (byte)
                    data;
                break;
            case 26:
                if (soundOn) {
                    if ((JavaBoy.
                           unsign(
                             data) &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel3.
                          setVolume(
                            (JavaBoy.
                               unsign(
                                 registers[28]) &
                               96) >>
                              5);
                    }
                    else {
                        dmgcpu.
                          soundChip.
                          channel3.
                          setVolume(
                            0);
                    }
                }
                registers[26] =
                  (byte)
                    data;
                break;
            case 27:
                registers[27] =
                  (byte)
                    data;
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel3.
                      setLength(
                        JavaBoy.
                          unsign(
                            data));
                break;
            case 28:
                registers[28] =
                  (byte)
                    data;
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel3.
                      setVolume(
                        (JavaBoy.
                           unsign(
                             registers[28]) &
                           96) >>
                          5);
                break;
            case 29:
                registers[29] =
                  (byte)
                    data;
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel3.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[30]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[29]));
                break;
            case 30:
                registers[30] =
                  (byte)
                    data;
                if (soundOn) {
                    if ((registers[25] &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel3.
                          setLength(
                            JavaBoy.
                              unsign(
                                registers[27]));
                    }
                    dmgcpu.
                      soundChip.
                      channel3.
                      setFrequency(
                        ((int)
                           (JavaBoy.
                              unsign(
                                registers[30]) &
                              7) <<
                           8) +
                          JavaBoy.
                          unsign(
                            registers[29]));
                }
                break;
            case 32:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel4.
                      setLength(
                        JavaBoy.
                          unsign(
                            data) &
                          63);
                registers[32] =
                  (byte)
                    data;
                break;
            case 33:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel4.
                      setEnvelope(
                        (JavaBoy.
                           unsign(
                             data) &
                           240) >>
                          4,
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          8);
                registers[33] =
                  (byte)
                    data;
                break;
            case 34:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel4.
                      setParameters(
                        JavaBoy.
                          unsign(
                            data) &
                          7,
                        (JavaBoy.
                           unsign(
                             data) &
                           8) ==
                          8,
                        (JavaBoy.
                           unsign(
                             data) &
                           240) >>
                          4);
                registers[34] =
                  (byte)
                    data;
                break;
            case 35:
                registers[35] =
                  (byte)
                    data;
                if (soundOn) {
                    if ((registers[35] &
                           128) !=
                          0) {
                        dmgcpu.
                          soundChip.
                          channel4.
                          setLength(
                            JavaBoy.
                              unsign(
                                registers[32]) &
                              63);
                    }
                    if ((registers[35] &
                           64) ==
                          0) {
                        dmgcpu.
                          soundChip.
                          channel4.
                          setLength(
                            -1);
                    }
                }
                break;
            case 37:
                int chanData;
                registers[37] =
                  (byte)
                    data;
                if (soundOn) {
                    chanData =
                      0;
                    if ((JavaBoy.
                           unsign(
                             data) &
                           1) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_LEFT;
                    }
                    if ((JavaBoy.
                           unsign(
                             data) &
                           16) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_RIGHT;
                    }
                    dmgcpu.
                      soundChip.
                      channel1.
                      setChannel(
                        chanData);
                    chanData =
                      0;
                    if ((JavaBoy.
                           unsign(
                             data) &
                           2) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_LEFT;
                    }
                    if ((JavaBoy.
                           unsign(
                             data) &
                           32) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_RIGHT;
                    }
                    dmgcpu.
                      soundChip.
                      channel2.
                      setChannel(
                        chanData);
                    chanData =
                      0;
                    if ((JavaBoy.
                           unsign(
                             data) &
                           4) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_LEFT;
                    }
                    if ((JavaBoy.
                           unsign(
                             data) &
                           64) !=
                          0) {
                        chanData |=
                          SquareWaveGenerator.
                            CHAN_RIGHT;
                    }
                    dmgcpu.
                      soundChip.
                      channel3.
                      setChannel(
                        chanData);
                }
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
                if (soundOn)
                    dmgcpu.
                      soundChip.
                      channel3.
                      setSamplePair(
                        num -
                          48,
                        JavaBoy.
                          unsign(
                            data));
                registers[num] =
                  (byte)
                    data;
                break;
            case 64:
                dmgcpu.
                  graphicsChip.
                  bgEnabled =
                  true;
                if ((data &
                       32) ==
                      32) {
                    dmgcpu.
                      graphicsChip.
                      winEnabled =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      winEnabled =
                      false;
                }
                if ((data &
                       16) ==
                      16) {
                    dmgcpu.
                      graphicsChip.
                      bgWindowDataSelect =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      bgWindowDataSelect =
                      false;
                }
                if ((data &
                       8) ==
                      8) {
                    dmgcpu.
                      graphicsChip.
                      hiBgTileMapAddress =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      hiBgTileMapAddress =
                      false;
                }
                if ((data &
                       4) ==
                      4) {
                    dmgcpu.
                      graphicsChip.
                      doubledSprites =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      doubledSprites =
                      false;
                }
                if ((data &
                       2) ==
                      2) {
                    dmgcpu.
                      graphicsChip.
                      spritesEnabled =
                      true;
                }
                else {
                    dmgcpu.
                      graphicsChip.
                      spritesEnabled =
                      false;
                }
                if ((data &
                       1) ==
                      0) {
                    dmgcpu.
                      graphicsChip.
                      bgEnabled =
                      false;
                    dmgcpu.
                      graphicsChip.
                      winEnabled =
                      false;
                }
                registers[64] =
                  (byte)
                    data;
                break;
            case 65:
                registers[65] =
                  (byte)
                    data;
                break;
            case 66:
                registers[66] =
                  (byte)
                    data;
                break;
            case 67:
                registers[67] =
                  (byte)
                    data;
                break;
            case 70:
                int sourceAddress =
                  data <<
                  8;
                for (int i =
                       0;
                     i <
                       160;
                     i++) {
                    dmgcpu.
                      addressWrite(
                        65024 +
                          i,
                        dmgcpu.
                          addressRead(
                            sourceAddress +
                              i));
                }
                break;
            case 71:
                dmgcpu.
                  graphicsChip.
                  backgroundPalette.
                  decodePalette(
                    data);
                if (registers[num] !=
                      (byte)
                        data) {
                    registers[num] =
                      (byte)
                        data;
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        GraphicsChip.
                          TILE_BKG);
                }
                break;
            case 72:
                dmgcpu.
                  graphicsChip.
                  obj1Palette.
                  decodePalette(
                    data);
                if (registers[num] !=
                      (byte)
                        data) {
                    registers[num] =
                      (byte)
                        data;
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        GraphicsChip.
                          TILE_OBJ1);
                }
                break;
            case 73:
                dmgcpu.
                  graphicsChip.
                  obj2Palette.
                  decodePalette(
                    data);
                if (registers[num] !=
                      (byte)
                        data) {
                    registers[num] =
                      (byte)
                        data;
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        GraphicsChip.
                          TILE_OBJ2);
                }
                break;
            case 79:
                if (dmgcpu.
                      gbcFeatures) {
                    dmgcpu.
                      graphicsChip.
                      tileStart =
                      (data &
                         1) *
                        384;
                    dmgcpu.
                      graphicsChip.
                      vidRamStart =
                      (data &
                         1) *
                        8192;
                }
                registers[79] =
                  (byte)
                    data;
                break;
            case 85:
                if (!hdmaRunning &&
                      (registers[85] &
                         128) ==
                      0 &&
                      (data &
                         128) ==
                      0) {
                    int dmaSrc =
                      (JavaBoy.
                         unsign(
                           registers[81]) <<
                         8) +
                      (JavaBoy.
                         unsign(
                           registers[82]) &
                         240);
                    int dmaDst =
                      ((JavaBoy.
                          unsign(
                            registers[83]) &
                          31) <<
                         8) +
                      (JavaBoy.
                         unsign(
                           registers[84]) &
                         240) +
                      32768;
                    int dmaLen =
                      (JavaBoy.
                         unsign(
                           data) &
                         127) *
                      16 +
                      16;
                    if (dmaLen >
                          2048)
                        dmaLen =
                          2048;
                    for (int r =
                           0;
                         r <
                           dmaLen;
                         r++) {
                        dmgcpu.
                          addressWrite(
                            dmaDst +
                              r,
                            dmgcpu.
                              addressRead(
                                dmaSrc +
                                  r));
                    }
                }
                else {
                    if ((JavaBoy.
                           unsign(
                             data) &
                           128) ==
                          128) {
                        hdmaRunning =
                          true;
                        registers[85] =
                          (byte)
                            (data &
                               127);
                        break;
                    }
                    else
                        if (hdmaRunning &&
                              (JavaBoy.
                                 unsign(
                                   data) &
                                 128) ==
                              0) {
                            hdmaRunning =
                              false;
                        }
                }
                registers[85] =
                  (byte)
                    data;
                break;
            case 105:
                if (dmgcpu.
                      gbcFeatures) {
                    int palNumber =
                      (registers[104] &
                         56) >>
                      3;
                    dmgcpu.
                      graphicsChip.
                      gbcBackground[palNumber].
                      setGbcColours(
                        (JavaBoy.
                           unsign(
                             registers[104]) &
                           6) >>
                          1,
                        (JavaBoy.
                           unsign(
                             registers[104]) &
                           1) ==
                          1,
                        JavaBoy.
                          unsign(
                            data));
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        palNumber *
                          4);
                    if ((JavaBoy.
                           unsign(
                             registers[104]) &
                           128) !=
                          0) {
                        registers[104]++;
                    }
                }
                registers[105] =
                  (byte)
                    data;
                break;
            case 107:
                if (dmgcpu.
                      gbcFeatures) {
                    int palNumber =
                      (registers[106] &
                         56) >>
                      3;
                    dmgcpu.
                      graphicsChip.
                      gbcSprite[palNumber].
                      setGbcColours(
                        (JavaBoy.
                           unsign(
                             registers[106]) &
                           6) >>
                          1,
                        (JavaBoy.
                           unsign(
                             registers[106]) &
                           1) ==
                          1,
                        JavaBoy.
                          unsign(
                            data));
                    dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        palNumber *
                          4 +
                          32);
                    if ((JavaBoy.
                           unsign(
                             registers[106]) &
                           128) !=
                          0) {
                        if ((registers[106] &
                               63) ==
                              63) {
                            registers[106] =
                              (byte)
                                128;
                        }
                        else {
                            registers[106]++;
                        }
                    }
                }
                registers[107] =
                  (byte)
                    data;
                break;
            case 112:
                if (dmgcpu.
                      gbcFeatures) {
                    if ((data &
                           7) ==
                          0 ||
                          (data &
                             7) ==
                          1) {
                        dmgcpu.
                          gbcRamBank =
                          1;
                    }
                    else {
                        dmgcpu.
                          gbcRamBank =
                          data &
                            7;
                    }
                }
                registers[112] =
                  (byte)
                    data;
                break;
            default:
                registers[num] =
                  (byte)
                    data;
                break;
        }
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
       "bpCUX3Xl/+Yd//L5n3/5q+XR+v8HGvGuHR4uAAA=");
}
