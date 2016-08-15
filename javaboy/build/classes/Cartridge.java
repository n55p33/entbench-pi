class Cartridge implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { if (rom.length >= 1048576) { return EntMode.
                                                                       HIGH_MODE;
                                 }
                                 else
                                     if (rom.
                                           length >=
                                           524288) {
                                         return EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return EntMode.
                                                  LOW_MODE;
                                     } }
    final int[][] romSizeTable = { { 0, 2 }, { 1, 4 }, { 2, 8 }, { 3,
    16 },
    { 4,
    32 },
    { 5,
    64 },
    { 6,
    128 },
    { 7,
    256 },
    { 82,
    72 },
    { 83,
    80 },
    { 84,
    96 } };
    final java.lang.String[] cartTypeTable = { "ROM Only", "ROM+MBC1",
    "ROM+MBC1+RAM",
    "ROM+MBC1+RAM+BATTERY",
    "Unknown",
    "ROM+MBC2",
    "ROM+MBC2+BATTERY",
    "Unknown",
    "ROM+RAM",
    "ROM+RAM+BATTERY",
    "Unknown",
    "Unsupported ROM+MMM01",
    "Unsupported ROM+MMM01+SRAM",
    "Unsupported ROM+MMM01+SRAM+BATTERY",
    "Unknown",
    "ROM+MBC3+TIMER+BATTERY",
    "ROM+MBC3+TIMER+RAM+BATTERY",
    "ROM+MBC3",
    "ROM+MBC3+RAM",
    "ROM+MBC3+RAM+BATTERY",
    "Unknown",
    "Unknown",
    "Unknown",
    "Unknown",
    "Unknown",
    "ROM+MBC5",
    "ROM+MBC5+RAM",
    "ROM+MBC5+RAM+BATTERY",
    "ROM+MBC5+RUMBLE",
    "ROM+MBC5+RUMBLE+RAM",
    "ROM+MBC5+RUMBLE+RAM+BATTERY" };
    final byte bNotCompressed = 0;
    final byte bZip = 1;
    final byte bJar = 2;
    final byte bGZip = 3;
    final byte SECONDS = 0;
    final byte MINUTES = 1;
    final byte HOURS = 2;
    final byte DAYS_LO = 3;
    final byte DAYS_HI = 4;
    public byte[] rom;
    public byte[] ram = new byte[65536];
    int numBanks;
    int cartType;
    int pageStart = 16384;
    int currentBank = 1;
    int savedBank = -1;
    int ramBank;
    int ramPageStart;
    boolean mbc1LargeRamMode = false;
    boolean ramEnabled;
    boolean disposed = false;
    java.awt.Component applet;
    java.lang.String romFileName;
    java.lang.String cartName;
    boolean cartridgeReady = false;
    boolean needsReset = false;
    int[] RTCReg = new int[5];
    long realTimeStart;
    long lastSecondIncrement;
    java.lang.String romIntFileName;
    public Cartridge(java.lang.String romFileName, java.awt.Component a) {
        super(
          );
        applet =
          a;
        this.
          romFileName =
          romFileName;
        java.io.InputStream is =
          null;
        try {
            is =
              openRom(
                romFileName,
                a);
            byte[] firstBank =
              new byte[16384];
            int total =
              16384;
            do  {
                total -=
                  is.
                    read(
                      firstBank,
                      16384 -
                        total,
                      total);
            }while(total >
                     0); 
            cartType =
              firstBank[327];
            numBanks =
              lookUpCartSize(
                firstBank[328]);
            rom =
              (new byte[16384 *
                          numBanks]);
            for (int r =
                   0;
                 r <
                   16384;
                 r++) {
                rom[r] =
                  firstBank[r];
            }
            total =
              16384 *
                (numBanks -
                   1);
            do  {
                total -=
                  is.
                    read(
                      rom,
                      rom.
                        length -
                        total,
                      total);
            }while(total >
                     0); 
            is.
              close(
                );
            JavaBoy.
              debugLog(
                "Loaded ROM \'" +
                romFileName +
                "\'.  " +
                numBanks +
                " banks, " +
                numBanks *
                  16 +
                "Kb.  " +
                getNumRAMBanks(
                  ) +
                " RAM banks.");
            JavaBoy.
              debugLog(
                "Type: " +
                cartTypeTable[cartType] +
                " (" +
                JavaBoy.
                  hexByte(
                    cartType) +
                ")");
            if (!verifyChecksum(
                   ) &&
                  a instanceof java.awt.Frame) {
                new ModalDialog(
                  (java.awt.Frame)
                    a,
                  "Warning",
                  "This cartridge has an invalid checksum.",
                  "It may not execute correctly.");
            }
            if (!JavaBoy.
                   runningAsApplet) {
                loadBatteryRam(
                  );
            }
            java.util.Calendar rightNow =
              java.util.Calendar.
              getInstance(
                );
            int days =
              rightNow.
              get(
                java.util.Calendar.
                  DAY_OF_YEAR);
            int hour =
              rightNow.
              get(
                java.util.Calendar.
                  HOUR_OF_DAY);
            int minute =
              rightNow.
              get(
                java.util.Calendar.
                  MINUTE);
            int second =
              rightNow.
              get(
                java.util.Calendar.
                  SECOND);
            RTCReg[SECONDS] =
              second;
            RTCReg[MINUTES] =
              minute;
            RTCReg[HOURS] =
              hour;
            RTCReg[DAYS_LO] =
              days &
                255;
            RTCReg[DAYS_HI] =
              (days &
                 511) >>
                8;
            realTimeStart =
              java.lang.System.
                currentTimeMillis(
                  );
            lastSecondIncrement =
              realTimeStart;
            cartridgeReady =
              true;
        }
        catch (java.io.IOException e) {
            java.lang.System.
              out.
              println(
                "Error opening ROM image \'" +
                romFileName +
                "\'!");
        }
        catch (java.lang.IndexOutOfBoundsException e) {
            new ModalDialog(
              (java.awt.Frame)
                a,
              "Error",
              "Loading the ROM image failed.",
              "The file is not a valid Gameboy ROM.");
        }
    }
    public boolean needsResetEnable() { if (needsReset) { needsReset =
                                                            false;
                                                          java.lang.System.
                                                            out.println(
                                                                  "Reset requested");
                                                          return true;
                                        }
                                        else {
                                            return false;
                                        } }
    public void resetSystem() { needsReset = true; }
    public void update() { long millisSinceLastUpdate = java.lang.System.
                             currentTimeMillis(
                               ) -
                             lastSecondIncrement;
                           while (millisSinceLastUpdate > 1000) {
                               millisSinceLastUpdate -=
                                 1000;
                               RTCReg[SECONDS]++;
                               if (RTCReg[SECONDS] ==
                                     60) {
                                   RTCReg[MINUTES]++;
                                   RTCReg[SECONDS] =
                                     0;
                                   if (RTCReg[MINUTES] ==
                                         60) {
                                       RTCReg[HOURS]++;
                                       RTCReg[MINUTES] =
                                         0;
                                       if (RTCReg[HOURS] ==
                                             24) {
                                           if (RTCReg[DAYS_LO] ==
                                                 255) {
                                               RTCReg[DAYS_LO] =
                                                 0;
                                               RTCReg[DAYS_HI] =
                                                 1;
                                           }
                                           else {
                                               RTCReg[DAYS_LO]++;
                                           }
                                           RTCReg[HOURS] =
                                             0;
                                       }
                                   }
                               }
                               lastSecondIncrement =
                                 java.lang.System.
                                   currentTimeMillis(
                                     );
                           } }
    java.lang.String stripExtention(java.lang.String filename) { int dotPosition =
                                                                   filename.
                                                                   lastIndexOf(
                                                                     '.');
                                                                 if (dotPosition !=
                                                                       -1) {
                                                                     return filename.
                                                                       substring(
                                                                         0,
                                                                         dotPosition);
                                                                 }
                                                                 else {
                                                                     return filename;
                                                                 }
    }
    public java.io.InputStream openRom(java.lang.String romFileName,
                                       java.awt.Component a) {
        byte bFormat;
        boolean bFoundGBROM =
          false;
        java.lang.String romName =
          "None";
        if (romFileName.
              toUpperCase(
                ).
              indexOf(
                "ZIP") >
              -1) {
            bFormat =
              bZip;
        }
        else
            if (romFileName.
                  toUpperCase(
                    ).
                  indexOf(
                    "JAR") >
                  -1) {
                bFormat =
                  bZip;
            }
            else
                if (romFileName.
                      toUpperCase(
                        ).
                      indexOf(
                        "GZ") >
                      -1) {
                    bFormat =
                      bGZip;
                }
                else {
                    bFormat =
                      bNotCompressed;
                }
        if (bFormat ==
              bNotCompressed) {
            try {
                romIntFileName =
                  stripExtention(
                    romFileName);
                if (JavaBoy.
                      runningAsApplet) {
                    return new java.net.URL(
                      ((java.applet.Applet)
                         a).
                        getDocumentBase(
                          ),
                      romFileName).
                      openStream(
                        );
                }
                else {
                    return new java.io.FileInputStream(
                      new java.io.File(
                        romFileName));
                }
            }
            catch (java.lang.Exception e) {
                java.lang.System.
                  out.
                  println(
                    "Cant open file");
                return null;
            }
        }
        if (bFormat ==
              bZip) {
            java.lang.System.
              out.
              println(
                "Loading ZIP Compressed ROM");
            java.util.zip.ZipInputStream zip;
            try {
                if (JavaBoy.
                      runningAsApplet) {
                    zip =
                      new java.util.zip.ZipInputStream(
                        new java.net.URL(
                          ((java.applet.Applet)
                             a).
                            getDocumentBase(
                              ),
                          romFileName).
                          openStream(
                            ));
                }
                else {
                    zip =
                      new java.util.zip.ZipInputStream(
                        new java.io.FileInputStream(
                          romFileName));
                }
                java.util.zip.ZipEntry ze;
                while ((ze =
                          zip.
                            getNextEntry(
                              )) !=
                         null) {
                    java.lang.String str =
                      ze.
                      getName(
                        );
                    if (str.
                          toUpperCase(
                            ).
                          indexOf(
                            ".GB") >
                          -1 ||
                          str.
                          toUpperCase(
                            ).
                          indexOf(
                            ".GBC") >
                          -1) {
                        bFoundGBROM =
                          true;
                        romIntFileName =
                          stripExtention(
                            str);
                        romName =
                          str;
                        break;
                    }
                }
                if (!bFoundGBROM) {
                    if (JavaBoy.
                          runningAsApplet) {
                        new ModalDialog(
                          (java.awt.Frame)
                            a,
                          "Error",
                          "No GBx ROM found!",
                          "");
                    }
                    java.lang.System.
                      err.
                      println(
                        "No GBx ROM found!");
                    throw new java.io.IOException(
                      "ERROR");
                }
                if (!JavaBoy.
                       runningAsApplet) {
                    java.lang.System.
                      out.
                      println(
                        "Found " +
                        romName);
                }
                return zip;
            }
            catch (java.lang.Exception e) {
                java.lang.System.
                  out.
                  println(
                    e);
                return null;
            }
        }
        if (bFormat ==
              bGZip) {
            java.lang.System.
              out.
              println(
                "Loading GZIP Compressed ROM");
            romIntFileName =
              stripExtention(
                romFileName);
            try {
                if (JavaBoy.
                      runningAsApplet) {
                    return new java.util.zip.GZIPInputStream(
                      new java.net.URL(
                        ((java.applet.Applet)
                           a).
                          getDocumentBase(
                            ),
                        romFileName).
                        openStream(
                          ));
                }
                else {
                    return new java.util.zip.GZIPInputStream(
                      new java.io.FileInputStream(
                        romFileName));
                }
            }
            catch (java.lang.Exception e) {
                java.lang.System.
                  out.
                  println(
                    "Can\'t open file");
                return null;
            }
        }
        return null;
    }
    public final byte addressRead(int addr) {
        if (addr >=
              40960 &&
              addr <=
              49151) {
            switch (cartType) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    {
                        if (ramBank >=
                              4) {
                            return (byte)
                                     RTCReg[ramBank -
                                              8];
                        }
                        else {
                            return ram[addr -
                                         40960 +
                                         ramPageStart];
                        }
                    }
                default:
                    {
                        return ram[addr -
                                     40960 +
                                     ramPageStart];
                    }
            }
        }
        if (addr <
              16384) {
            return (byte)
                     rom[addr];
        }
        else {
            return (byte)
                     rom[pageStart +
                           addr -
                           16384];
        }
    }
    public java.lang.String getMapInfo() {
        java.lang.String out;
        switch (cartType) {
            case 0:
            case 8:
            case 9:
                return "This ROM has no mapper.";
            case 1:
                return "MBC1: ROM bank " +
                JavaBoy.
                  hexByte(
                    currentBank) +
                " mapped to " +
                " 4000 - 7FFFF";
            case 2:
            case 3:
                out =
                  "MBC1: ROM bank " +
                  JavaBoy.
                    hexByte(
                      currentBank) +
                  " mapped to " +
                  " 4000 - 7FFFF.  ";
                if (mbc1LargeRamMode) {
                    out =
                      out +
                      "Cartridge is in 16MBit ROM/8KByte RAM Mode.";
                }
                else {
                    out =
                      out +
                      "Cartridge is in 4MBit ROM/32KByte RAM Mode.";
                }
                return out;
            case 5:
            case 6:
                return "MBC2: ROM bank " +
                JavaBoy.
                  hexByte(
                    currentBank) +
                " mapped to 4000 - 7FFF";
            case 25:
            case 28:
                return "MBC5: ROM bank " +
                JavaBoy.
                  hexByte(
                    currentBank) +
                " mapped to 4000 - 7FFF";
            case 26:
            case 27:
            case 29:
            case 30:
                return "MBC5: ROM bank " +
                JavaBoy.
                  hexByte(
                    currentBank) +
                " mapped to 4000 - 7FFF";
        }
        return "Unknown mapper.";
    }
    public void mapRom(int bankNo) { currentBank =
                                       bankNo;
                                     pageStart =
                                       16384 *
                                         bankNo;
    }
    public void reset() { mapRom(1); }
    public void saveMapping() { if (cartType !=
                                      0 &&
                                      savedBank ==
                                      -1)
                                    savedBank =
                                      currentBank;
    }
    public void restoreMapping() { if (savedBank !=
                                         -1) {
                                       java.lang.System.
                                         out.
                                         println(
                                           "- ROM Mapping restored to bank " +
                                           JavaBoy.
                                             hexByte(
                                               savedBank));
                                       addressWrite(
                                         8192,
                                         savedBank);
                                       savedBank =
                                         -1;
                                   } }
    public void debuggerAddressWrite(int addr,
                                     int data) {
        if (cartType ==
              0) {
            rom[addr] =
              (byte)
                data;
        }
        else {
            if (addr <
                  16384) {
                rom[addr] =
                  (byte)
                    data;
            }
            else {
                rom[pageStart +
                      addr -
                      16384] =
                  (byte)
                    data;
            }
        }
    }
    public final void addressWrite(int addr,
                                   int data) {
        int ramAddress =
          0;
        switch (cartType) {
            case 0:
                break;
            case 1:
            case 2:
            case 3:
                if (addr >=
                      40960 &&
                      addr <=
                      49151) {
                    if (ramEnabled) {
                        ramAddress =
                          addr -
                            40960 +
                            ramPageStart;
                        ram[ramAddress] =
                          (byte)
                            data;
                    }
                }
                if (addr >=
                      8192 &&
                      addr <=
                      16383) {
                    int bankNo =
                      data &
                      31;
                    if (bankNo ==
                          0)
                        bankNo =
                          1;
                    mapRom(
                      currentBank &
                        96 |
                        bankNo);
                }
                else
                    if (addr >=
                          24576 &&
                          addr <=
                          32767) {
                        if ((data &
                               1) ==
                              1) {
                            mbc1LargeRamMode =
                              true;
                        }
                        else {
                            mbc1LargeRamMode =
                              false;
                        }
                    }
                    else
                        if (addr <=
                              8191) {
                            if ((data &
                                   15) ==
                                  10) {
                                ramEnabled =
                                  true;
                            }
                            else {
                                ramEnabled =
                                  false;
                            }
                        }
                        else
                            if (addr <=
                                  24575 &&
                                  addr >=
                                  16384) {
                                if (mbc1LargeRamMode) {
                                    ramBank =
                                      data &
                                        3;
                                    ramPageStart =
                                      ramBank *
                                        8192;
                                }
                                else {
                                    mapRom(
                                      currentBank &
                                        31 |
                                        (data &
                                           3) <<
                                        5);
                                }
                            }
                break;
            case 5:
            case 6:
                if (addr >=
                      8192 &&
                      addr <=
                      16383 &&
                      (addr &
                         256) !=
                      0) {
                    int bankNo =
                      data &
                      31;
                    if (bankNo ==
                          0)
                        bankNo =
                          1;
                    mapRom(
                      bankNo);
                }
                if (addr >=
                      40960 &&
                      addr <=
                      49151) {
                    if (ramEnabled)
                        ram[addr -
                              40960 +
                              ramPageStart] =
                          (byte)
                            data;
                }
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                if (addr >=
                      8192 &&
                      addr <=
                      16383) {
                    int bankNo =
                      data &
                      127;
                    if (bankNo ==
                          0)
                        bankNo =
                          1;
                    mapRom(
                      bankNo);
                }
                else
                    if (addr <=
                          24575 &&
                          addr >=
                          16384) {
                        ramBank =
                          data;
                        if (ramBank <
                              4) {
                            ramPageStart =
                              ramBank *
                                8192;
                        }
                    }
                if (addr >=
                      40960 &&
                      addr <=
                      49151) {
                    if (ramBank <=
                          3) {
                        ram[addr -
                              40960 +
                              ramPageStart] =
                          (byte)
                            data;
                    }
                    else {
                        RTCReg[ramBank -
                                 8] =
                          data;
                    }
                }
                break;
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                if (addr >=
                      8192 &&
                      addr <=
                      12287) {
                    int bankNo =
                      currentBank &
                      65280 |
                      data;
                    mapRom(
                      bankNo);
                }
                if (addr >=
                      12288 &&
                      addr <=
                      16383) {
                    int bankNo =
                      currentBank &
                      255 |
                      (data &
                         1) <<
                      8;
                    mapRom(
                      bankNo);
                }
                if (addr >=
                      16384 &&
                      addr <=
                      24575) {
                    ramBank =
                      data &
                        7;
                    ramPageStart =
                      ramBank *
                        8192;
                }
                if (addr >=
                      40960 &&
                      addr <=
                      49151) {
                    ram[addr -
                          40960 +
                          ramPageStart] =
                      (byte)
                        data;
                }
                break;
        }
    }
    public int getNumRAMBanks() { switch (rom[329]) {
                                      case 0:
                                          {
                                              return 0;
                                          }
                                      case 1:
                                      case 2:
                                          {
                                              return 1;
                                          }
                                      case 3:
                                          {
                                              return 4;
                                          }
                                      case 4:
                                          {
                                              return 16;
                                          }
                                  }
                                  return 0;
    }
    public void loadBatteryRam() { java.lang.String saveRamFileName =
                                     romFileName;
                                   int numRamBanks;
                                   try { int dotPosition =
                                           romFileName.
                                           lastIndexOf(
                                             '.');
                                         if (dotPosition !=
                                               -1) {
                                             saveRamFileName =
                                               romFileName.
                                                 substring(
                                                   0,
                                                   dotPosition) +
                                               ".sav";
                                         }
                                         else {
                                             saveRamFileName =
                                               romFileName +
                                               ".sav";
                                         }
                                         numRamBanks =
                                           getNumRAMBanks(
                                             );
                                         if (cartType ==
                                               3 ||
                                               cartType ==
                                               9 ||
                                               cartType ==
                                               27 ||
                                               cartType ==
                                               30 ||
                                               cartType ==
                                               16 ||
                                               cartType ==
                                               19) {
                                             java.io.FileInputStream is =
                                               new java.io.FileInputStream(
                                               new java.io.File(
                                                 saveRamFileName));
                                             is.
                                               read(
                                                 ram,
                                                 0,
                                                 numRamBanks *
                                                   8192);
                                             is.
                                               close(
                                                 );
                                             java.lang.System.
                                               out.
                                               println(
                                                 "Read SRAM from \'" +
                                                 saveRamFileName +
                                                 "\'");
                                         }
                                         if (cartType ==
                                               6) {
                                             java.io.FileInputStream is =
                                               new java.io.FileInputStream(
                                               new java.io.File(
                                                 saveRamFileName));
                                             is.
                                               read(
                                                 ram,
                                                 0,
                                                 512);
                                             is.
                                               close(
                                                 );
                                             java.lang.System.
                                               out.
                                               println(
                                                 "Read SRAM from \'" +
                                                 saveRamFileName +
                                                 "\'");
                                         }
                                   }
                                   catch (java.io.IOException e) {
                                       java.lang.System.
                                         out.
                                         println(
                                           "Error loading battery RAM from \'" +
                                           saveRamFileName +
                                           "\'");
                                   } }
    public int getBatteryRamSize() { int numRamBanks;
                                     if (rom[329] ==
                                           6) {
                                         return 512;
                                     }
                                     else {
                                         return getNumRAMBanks(
                                                  ) *
                                           8192;
                                     } }
    public byte[] getBatteryRam() { return ram;
    }
    public boolean canSave() { return cartType ==
                                 3 ||
                                 cartType ==
                                 9 ||
                                 cartType ==
                                 27 ||
                                 cartType ==
                                 30 ||
                                 cartType ==
                                 6 ||
                                 cartType ==
                                 16 ||
                                 cartType ==
                                 19; }
    public void saveBatteryRam() { java.lang.String saveRamFileName =
                                     romFileName;
                                   int numRamBanks;
                                   numRamBanks =
                                     getNumRAMBanks(
                                       );
                                   try { int dotPosition =
                                           romFileName.
                                           lastIndexOf(
                                             '.');
                                         if (dotPosition !=
                                               -1) {
                                             saveRamFileName =
                                               romFileName.
                                                 substring(
                                                   0,
                                                   dotPosition) +
                                               ".sav";
                                         }
                                         else {
                                             saveRamFileName =
                                               romFileName +
                                               ".sav";
                                         }
                                         if (cartType ==
                                               3 ||
                                               cartType ==
                                               9 ||
                                               cartType ==
                                               27 ||
                                               cartType ==
                                               30 ||
                                               cartType ==
                                               16 ||
                                               cartType ==
                                               19) {
                                             java.io.FileOutputStream os =
                                               new java.io.FileOutputStream(
                                               new java.io.File(
                                                 saveRamFileName));
                                             os.
                                               write(
                                                 ram,
                                                 0,
                                                 numRamBanks *
                                                   8192);
                                             os.
                                               close(
                                                 );
                                             java.lang.System.
                                               out.
                                               println(
                                                 "Written SRAM to \'" +
                                                 saveRamFileName +
                                                 "\'");
                                         }
                                         if (cartType ==
                                               6) {
                                             java.io.FileOutputStream os =
                                               new java.io.FileOutputStream(
                                               new java.io.File(
                                                 saveRamFileName));
                                             os.
                                               write(
                                                 ram,
                                                 0,
                                                 512);
                                             os.
                                               close(
                                                 );
                                             java.lang.System.
                                               out.
                                               println(
                                                 "Written SRAM to \'" +
                                                 saveRamFileName +
                                                 "\'");
                                         }
                                   }
                                   catch (java.io.IOException e) {
                                       java.lang.System.
                                         out.
                                         println(
                                           "Error saving battery RAM to \'" +
                                           saveRamFileName +
                                           "\'");
                                   } }
    public void saveBatteryRAMToWeb(java.net.URL url,
                                    java.lang.String username,
                                    Dmgcpu cpu) {
        new WebSaveRAM(
          url,
          true,
          this,
          cpu,
          username);
    }
    public void loadBatteryRAMFromWeb(java.net.URL url,
                                      java.lang.String username,
                                      Dmgcpu cpu) {
        new WebSaveRAM(
          url,
          false,
          this,
          cpu,
          username);
    }
    public void dispose() { if (!JavaBoy.
                                   runningAsApplet) {
                                saveBatteryRam(
                                  );
                            }
                            disposed = true;
    }
    public boolean verifyChecksum() { int checkSum =
                                        (JavaBoy.
                                           unsign(
                                             rom[334]) <<
                                           8) +
                                        JavaBoy.
                                        unsign(
                                          rom[335]);
                                      int total =
                                        0;
                                      for (int r =
                                             0;
                                           r <
                                             rom.
                                               length;
                                           r++) {
                                          if (r !=
                                                334 &&
                                                r !=
                                                335) {
                                              total =
                                                total +
                                                  JavaBoy.
                                                  unsign(
                                                    rom[r]) &
                                                  65535;
                                          }
                                      }
                                      return checkSum ==
                                        total;
    }
    java.lang.String getCartName() { return cartName;
    }
    java.lang.String getRomFilename() { return romIntFileName;
    }
    public void outputCartInfo() { boolean checksumOk;
                                   cartName =
                                     new java.lang.String(
                                       rom,
                                       308,
                                       16);
                                   checksumOk =
                                     verifyChecksum(
                                       );
                                   java.lang.String s =
                                     "";
                                   for (int r =
                                          0;
                                        r <
                                          cartName.
                                          length(
                                            );
                                        r++) {
                                       if ((int)
                                             cartName.
                                             charAt(
                                               r) !=
                                             0 &&
                                             (int)
                                               cartName.
                                               charAt(
                                                 r) >=
                                             32 &&
                                             (int)
                                               cartName.
                                               charAt(
                                                 r) <=
                                             127) {
                                           s +=
                                             cartName.
                                               charAt(
                                                 r);
                                       }
                                   }
                                   cartName =
                                     s;
                                   java.lang.String infoString =
                                     "ROM Info: Name = " +
                                   cartName +
                                   ", Size = " +
                                   numBanks *
                                     128 +
                                   "Kbit, ";
                                   if (checksumOk) {
                                       infoString =
                                         infoString +
                                         "Checksum Ok.";
                                   }
                                   else {
                                       infoString =
                                         infoString +
                                         "Checksum invalid!";
                                   }
                                   JavaBoy.
                                     debugLog(
                                       infoString);
    }
    public int lookUpCartSize(int sizeByte) {
        int i =
          0;
        while (i <
                 romSizeTable.
                   length &&
                 romSizeTable[i][0] !=
                 sizeByte) {
            i++;
        }
        if (romSizeTable[i][0] ==
              sizeByte) {
            return romSizeTable[i][1];
        }
        else {
            return -1;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public Cartridge() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        Cartridge ENT_ld =
          new Cartridge(
          );
        ENT_ld.
          rom =
          this.
            rom;
        ENT_ld.
          ram =
          this.
            ram;
        ENT_ld.
          numBanks =
          this.
            numBanks;
        ENT_ld.
          cartType =
          this.
            cartType;
        ENT_ld.
          pageStart =
          this.
            pageStart;
        ENT_ld.
          currentBank =
          this.
            currentBank;
        ENT_ld.
          savedBank =
          this.
            savedBank;
        ENT_ld.
          ramBank =
          this.
            ramBank;
        ENT_ld.
          ramPageStart =
          this.
            ramPageStart;
        ENT_ld.
          mbc1LargeRamMode =
          this.
            mbc1LargeRamMode;
        ENT_ld.
          ramEnabled =
          this.
            ramEnabled;
        ENT_ld.
          disposed =
          this.
            disposed;
        ENT_ld.
          applet =
          this.
            applet;
        ENT_ld.
          romFileName =
          this.
            romFileName;
        ENT_ld.
          cartName =
          this.
            cartName;
        ENT_ld.
          cartridgeReady =
          this.
            cartridgeReady;
        ENT_ld.
          needsReset =
          this.
            needsReset;
        ENT_ld.
          RTCReg =
          this.
            RTCReg;
        ENT_ld.
          realTimeStart =
          this.
            realTimeStart;
        ENT_ld.
          lastSecondIncrement =
          this.
            lastSecondIncrement;
        ENT_ld.
          romIntFileName =
          this.
            romIntFileName;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XR6pQ7EWEsDvz08cJS0lCiwpaQ0T4Lxb");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+h99/gvr7wT+P8hk8DaXYgAA");
}
class NoSaveDataException extends java.lang.Exception {
    public NoSaveDataException(java.lang.String s) {
        super(
          s);
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
      ("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");
}
class WebSaveRAM implements java.lang.Runnable, DialogListener {
    Cartridge cart;
    boolean save;
    java.net.URL url;
    Dmgcpu cpu;
    java.lang.String username;
    public WebSaveRAM(java.net.URL url, boolean save,
                      Cartridge cart,
                      Dmgcpu cpu,
                      java.lang.String username) {
        super(
          );
        this.
          url =
          url;
        this.
          save =
          save;
        this.
          cart =
          cart;
        this.
          cpu =
          cpu;
        this.
          username =
          username;
        if (!cart.
              canSave(
                )) {
            ModalDialog d =
              new ModalDialog(
              null,
              "Sorry",
              "This game does not",
              "have a save facility.");
        }
        else {
            if (save) {
                ModalDialog d =
                  new ModalDialog(
                  null,
                  "Confirm",
                  "Are you sure you want to save?",
                  this);
            }
            else {
                ModalDialog d =
                  new ModalDialog(
                  null,
                  "Confirm",
                  "Are you sure you want to load?",
                  this);
            }
        }
    }
    public void yesPressed() { java.lang.Thread t =
                                 new java.lang.Thread(
                                 this);
                               t.start();
    }
    public void noPressed() {  }
    public void run() { java.awt.Frame f =
                          new java.awt.Frame(
                          "Please Wait...");
                        f.setSize(200, 120);
                        try { if (save) {
                                  f.
                                    add(
                                      new java.awt.Label(
                                        "Please wait, saving"),
                                      "North");
                                  f.
                                    add(
                                      new java.awt.Label(
                                        "game data to web server..."),
                                      "Center");
                                  f.
                                    show(
                                      );
                                  saveRam(
                                    );
                                  new ModalDialog(
                                    null,
                                    "Sucess!",
                                    "Game data",
                                    "Saved ok.");
                              }
                              else {
                                  f.
                                    add(
                                      new java.awt.Label(
                                        "Please wait, loading"),
                                      "North");
                                  f.
                                    add(
                                      new java.awt.Label(
                                        "game data from web server..."),
                                      "Center");
                                  f.
                                    show(
                                      );
                                  loadRam(
                                    );
                                  new ModalDialog(
                                    null,
                                    "Success!",
                                    "Game data",
                                    "loaded ok.");
                              } }
                        catch (NoSaveDataException e) {
                            java.lang.System.
                              out.
                              println(
                                "Error! " +
                                e);
                            new ModalDialog(
                              null,
                              "Error!",
                              "No save data can be found on the server!",
                              e.
                                toString(
                                  ));
                        }
                        catch (java.lang.Exception e) {
                            java.lang.System.
                              out.
                              println(
                                "Error! " +
                                e);
                            new ModalDialog(
                              null,
                              "Error!",
                              "Load/Save error!  Report to site administrator.",
                              e.
                                toString(
                                  ));
                        }
                        f.hide(); }
    public void saveRam() throws java.lang.Exception {
        java.lang.String params =
          "";
        java.lang.String strUrl =
          url.
          toString(
            );
        int questionPos =
          strUrl.
          indexOf(
            "?");
        if (questionPos !=
              -1) {
            params =
              "&" +
              strUrl.
                substring(
                  questionPos +
                    1,
                  strUrl.
                    length(
                      ));
        }
        java.lang.System.
          out.
          println(
            "Params: (" +
            url +
            ") " +
            params);
        url =
          new java.net.URL(
            url.
              getProtocol(
                ),
            url.
              getHost(
                ),
            url.
              getPort(
                ),
            url.
              getFile(
                ) +
            "?user=" +
            java.net.URLEncoder.
              encode(
                username));
        java.net.HttpURLConnection conn =
          (java.net.HttpURLConnection)
            url.
            openConnection(
              );
        conn.
          setRequestMethod(
            "POST");
        conn.
          setRequestProperty(
            "Content-Type",
            "application/x-www-form-urlencoded");
        conn.
          setDoOutput(
            true);
        conn.
          setDoInput(
            true);
        conn.
          connect(
            );
        java.io.DataOutputStream printout =
          new java.io.DataOutputStream(
          conn.
            getOutputStream(
              ));
        java.lang.StringBuffer saveData =
          new java.lang.StringBuffer(
          "");
        byte[] ram =
          cart.
          getBatteryRam(
            );
        for (int r =
               0;
             r <
               cart.
               getBatteryRamSize(
                 );
             r++) {
            saveData.
              append(
                JavaBoy.
                  hexByte(
                    JavaBoy.
                      unsign(
                        ram[r])));
        }
        java.lang.String content =
          "romname=" +
        java.net.URLEncoder.
          encode(
            cart.
              getRomFilename(
                )) +
        "&gamename=" +
        java.net.URLEncoder.
          encode(
            cart.
              getCartName(
                )) +
        "&user=" +
        java.net.URLEncoder.
          encode(
            username) +
        "&datalength=" +
        cart.
          getBatteryRamSize(
            ) *
          2 +
        "&data0=" +
        saveData +
        params;
        java.lang.System.
          out.
          println(
            content);
        printout.
          writeBytes(
            content);
        printout.
          flush(
            );
        printout.
          close(
            );
        conn.
          disconnect(
            );
        java.io.DataInputStream input =
          new java.io.DataInputStream(
          conn.
            getInputStream(
              ));
        java.lang.String str;
        while (null !=
                 (str =
                    input.
                      readLine(
                        ))) {
            java.lang.System.
              out.
              println(
                str);
        }
        java.lang.System.
          out.
          println(
            "OK!");
    }
    public void loadRam() throws java.lang.Exception {
        java.lang.String params =
          "";
        java.lang.String strUrl =
          url.
          toString(
            );
        int questionPos =
          strUrl.
          indexOf(
            "?");
        if (questionPos !=
              -1) {
            params =
              "&" +
              strUrl.
                substring(
                  questionPos +
                    1,
                  strUrl.
                    length(
                      ));
        }
        java.lang.System.
          out.
          println(
            "Params: (" +
            url +
            ") " +
            params);
        url =
          new java.net.URL(
            url.
              getProtocol(
                ),
            url.
              getHost(
                ),
            url.
              getPort(
                ),
            url.
              getFile(
                ) +
            "?user=" +
            java.net.URLEncoder.
              encode(
                username) +
            params);
        java.net.HttpURLConnection conn =
          (java.net.HttpURLConnection)
            url.
            openConnection(
              );
        conn.
          setRequestMethod(
            "POST");
        conn.
          setRequestProperty(
            "Content-Type",
            "application/x-www-form-urlencoded");
        conn.
          setDoOutput(
            true);
        conn.
          setDoInput(
            true);
        conn.
          connect(
            );
        java.io.DataOutputStream printout =
          new java.io.DataOutputStream(
          conn.
            getOutputStream(
              ));
        java.lang.String content =
          "gamename=" +
        java.net.URLEncoder.
          encode(
            cart.
              getCartName(
                )) +
        "&romname=" +
        java.net.URLEncoder.
          encode(
            cart.
              getRomFilename(
                ));
        printout.
          writeBytes(
            content);
        printout.
          flush(
            );
        printout.
          close(
            );
        conn.
          disconnect(
            );
        java.io.DataInputStream input =
          new java.io.DataInputStream(
          conn.
            getInputStream(
              ));
        java.lang.String str;
        str =
          input.
            readLine(
              );
        if (str.
              equals(
                "NOSAVERAM")) {
            throw new NoSaveDataException(
              "");
        }
        if (str.
              startsWith(
                "ERROR")) {
            throw new java.lang.Exception(
              str);
        }
        int pos =
          0;
        try {
            for (int r =
                   0;
                 r <
                   cart.
                   getBatteryRamSize(
                     );
                 r++) {
                java.lang.String sub =
                  str.
                  substring(
                    r *
                      2,
                    r *
                      2 +
                      2);
                int val =
                  java.lang.Integer.
                  valueOf(
                    sub,
                    16).
                  intValue(
                    );
                cart.
                  ram[r] =
                  (byte)
                    val;
            }
        }
        catch (java.lang.Exception e) {
            throw e;
        }
        cpu.
          reset(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P3rj733oG/kV9v8BtwUz6b4mAAA=");
}
