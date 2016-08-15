class GameBoyPrinter extends GameLink {
    final int BUFFER_SIZE = 32768;
    final int IMAGE_WIDTH = 160;
    final int IMAGE_HEIGHT = 320;
    final int[] palette = { -1, -8355712, -12566464, -16777216 };
    GameBoyPrinter.GameBoyPrinterWindow window;
    Dmgcpu cpu;
    short[] buffer = new short[BUFFER_SIZE];
    int bufferFillPos;
    int bufferEmptyPos;
    int tileX;
    int tileY;
    int dataSize;
    java.awt.image.MemoryImageSource source;
    java.awt.Image image;
    int[] imageData = new int[IMAGE_WIDTH * IMAGE_HEIGHT];
    class GameBoyPrinterWindow extends java.awt.Frame {
        java.awt.Image i;
        int scale = 2;
        GameBoyPrinterWindow(java.lang.String title) { super(title);
                                                       setSize(IMAGE_WIDTH *
                                                                 2,
                                                               IMAGE_HEIGHT *
                                                                 2);
                                                       setResizable(false);
        }
        public void setImage(java.awt.Image i) { this.i = i; }
        public void update(java.awt.Graphics g) { paint(g); }
        public void paint(java.awt.Graphics g) { g.setColor(new java.awt.Color(
                                                              255,
                                                              0,
                                                              255));
                                                 g.drawImage(i, 0, 0, IMAGE_WIDTH *
                                                               2,
                                                             IMAGE_HEIGHT *
                                                               2,
                                                             null);
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1470933729000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39gG/wJGMKHAXNQ8VFfCUlbYkqDjQ0mZ/tk" +
                                                                  "U1c9Csfc3pxvYW932Z2zz07dJEgVTqUgQgnQivAXESkiJaoatWmbiCpqkyhp" +
                                                                  "pST0I61CqrZSaVPUoKppVdqm783u3t7ufSDU1tKOd2feezPv6/fe3KUbpMY0" +
                                                                  "SAdTeRef0pnZ1afyKDVMluxVqGnugbm4dLqK/mX/9aEtQVIbI01pag5K1GT9" +
                                                                  "MlOSZowsl1WTU1Vi5hBjSeSIGsxkxgTlsqbGyELZHMjoiizJfFBLMiQYo0aE" +
                                                                  "tFLODTmR5WzAFsDJ8gicJCxOEt7uX+6OkHmSpk+55IsLyHsLVpAy4+5lctIS" +
                                                                  "OUgnaDjLZSUckU3enTPIBl1TpsYVjXexHO86qNxrm2B35N4iE3Q+2/zBrePp" +
                                                                  "FmGC+VRVNS7UM0eYqSkTLBkhze5sn8Iy5mHyRVIVIXMLiDkJRZxNw7BpGDZ1" +
                                                                  "tHWp4PSNTM1mejWhDnck1eoSHoiTVV4hOjVoxhYTFWcGCXXc1l0wg7Yr89pa" +
                                                                  "Whap+MSG8MnT+1u+WUWaY6RZVkfxOBIcgsMmMTAoyySYYW5PJlkyRlpVcPYo" +
                                                                  "M2SqyNO2p9tMeVylPAvud8yCk1mdGWJP11bgR9DNyEpcM/LqpURA2V81KYWO" +
                                                                  "g67trq6Whv04Dwo2yHAwI0Uh7myW6kOymuRkhZ8jr2PoASAA1jkZxtNafqtq" +
                                                                  "lcIEabNCRKHqeHgUQk8dB9IaDQLQ4GRJWaFoa51Kh+g4i2NE+uii1hJQ1QtD" +
                                                                  "IAsnC/1kQhJ4aYnPSwX+uTG09diD6i41SAJw5iSTFDz/XGDq8DGNsBQzGOSB" +
                                                                  "xThvfeQUbX9hNkgIEC/0EVs03/7Czfs3dlx5xaJZWoJmOHGQSTwunU80vbGs" +
                                                                  "d92WKjxGna6ZMjrfo7nIsqi90p3TAWHa8xJxsctZvDLyo889fJG9FyQNA6RW" +
                                                                  "0pRsBuKoVdIyuqwwYydTmUE5Sw6QeqYme8X6AJkD7xFZZdbscCplMj5AqhUx" +
                                                                  "VauJbzBRCkSgiRrgXVZTmvOuU54W7zmdEBKAh9TCs4NYf+I/J/eF01qGhXU5" +
                                                                  "HDU0VN0MA9gkwKzpMAZKQpsKm4YU3gnB06NNRQ0Rj124pP9X3Dk82/zJQADM" +
                                                                  "tsyftArE+y5NSTIjLp3M9vTd/Eb8NSsgMIhtrThZ7ZUb8n5+FtJAmySBgNhj" +
                                                                  "AW5quQWMegjSE/Bx3rrRfbsPzHZWQTzok9VoJyDt9NSJXjeHHeCNS5fbGqdX" +
                                                                  "Xdv0UpBUR0gblXiWKgj7241xABTpkJ1z8xJQQVwgX1kA5FiBDE1iScCRcoBu" +
                                                                  "S6nTJpiB85wsKJDglBlMqHB5kC95fnLlzOQjYw99LEiCXuzGLWsAdpA9ioib" +
                                                                  "R9aQP2dLyW0+ev2Dy6dmNDd7PcXAqWFFnKhDpz8K/OaJS+tX0ufiL8yEhNnr" +
                                                                  "AV05hWwA4Orw7+EBh24HaFGXOlA4pRkZquCSY+MGnja0SXdGhGereF8AYRHE" +
                                                                  "bGmHZ5edPuI/rrbrOC6ywhnjzKeFAPJPjepP/uInf9gszO1gfnNBsR5lvLsA" +
                                                                  "Z1BYm0CUVjds9xiMAd07Z6JfeeLG0b0iZoFidakNQzj2Ar6AC8HMX3rl8Nvv" +
                                                                  "Xjt/NZiPc5Lz6hasoBtsstY9BsCTApmOwRL6jAphKadkmlAY5tM/m9dseu5P" +
                                                                  "x1os9ysw40TPxtsLcOfv6iEPv7b/bx1CTEDC8uiayiWzMHe+K3m7YdApPEfu" +
                                                                  "kTeXf/Vl+iSgNyCmKU8zCwTtFMdDLYZuSXBiJeyyKqFw4j1iOSzGzWgJ2174" +
                                                                  "/Ukc1piFyeDNt4L+Ji4dv/p+49j7L94UangbpELfD1K92wo3HNbmQPwiP1jt" +
                                                                  "omYa6O65MvT5FuXKLZAYA4kSdAXmsAEwmfNEik1dM+eXP3ip/cAbVSTYTxoU" +
                                                                  "jSb7qUg6Ug/Rzsw0IGxO//T9ltcn62BoEaqSIuWLJtDyK0r7tC+jc+GF6e8s" +
                                                                  "+tbWC+euiajTLRlLBX8QQd+DsqLNdhP94luf+OmFx09NWoV6XXl08/Et/sew" +
                                                                  "kjjym78XmVzgWokmwscfC186u6R323uC3wUY5A7ligsVgLTLe/fFzF+DnbU/" +
                                                                  "DJI5MdIi2W3tGFWymLYxaOVMp9eF1tez7m3LrB6kOw+gy/zgVrCtH9rcAgnv" +
                                                                  "SI3vjaXQrAGePjvj+/xoFiDiZbdg+QgOG4rxohw3JwHZybEmESN0kncNZKBB" +
                                                                  "tFASxy04PGAFxdayMbjDuysu9du79pc582jFM5fj5nBDlKjCvOUfS+xoNmFC" +
                                                                  "qZYzgMwTdq95d/SANBuK/s4Kz7tKMFh0C58OPzb284OvC9yvw2Zgj+OSglIP" +
                                                                  "TUNB0WmxDv0h/AXg+Tc+eFicsHq2tl67cVyZ7xwxvSrmiU+B8Ezbu4fOXn/G" +
                                                                  "UsCfFD5iNnvyyx92HTtpobp1/VhddAMo5LGuIJY6OOzF062qtIvg6P/95Znv" +
                                                                  "PT1z1DpVm7eZ7oO74jM/+9frXWd+/WqJXrBKtq+QmwuAHsqx1zeWQjsebf7+" +
                                                                  "8baqfmgjBkhdVpUPZ9lA0ps8c8xsosBZ7rXGTShbNXQMhPx68IEvvPdUCO9c" +
                                                                  "qTAVXXrA36UXlmIXQwnadHm5i5Sw5/kjJ88lh5/aFLTLV4KTWvt+68qpQjEe" +
                                                                  "LB4U90YX2N5pOvHb50PjPXfS7OJcx23aWfxeAY5eXz5s/Ud5+cgfl+zZlj5w" +
                                                                  "B33rCp+J/CK/Pnjp1Z1rpRNBcUm2ELfocu1l6vaGSoPBeNZQvcGxOu/UenTW" +
                                                                  "CniGbKcOle4dRTyIcT0OH7ViGFymZxOKLPkatroKAn0djJ0N+Dks9pqp0OI8" +
                                                                  "hMMEJ3V420TIFlT77CzGf5ST6glNTrpxPnk7GK/cSuBEjy7mDa/VVsIzYis5" +
                                                                  "UsFqOEwV26cca2n7OCWrNV+ydhpUT8uSKbZ6rILRHsdhFlyV1ZMAx/j1iGue" +
                                                                  "R/9f5sGgGrN1HLtz85RjLR8+x4TUsxUscQ6H01BNdWicuM8QZ/4XhsjBLbjU" +
                                                                  "RT/fcXgX9eJOpB/ggeUCXizNH3Lh7Q5ZAL+rPcglfqF0UCZr/UYZly6f2z30" +
                                                                  "4M2PP2Xd/SSFTk+jlLlQYqxraB6pVpWV5siq3bXuVtOz9WscQG+1Duy6emmB" +
                                                                  "K3rAaTr26Ut8NyQzlL8ovX1+64s/nq19EwrqXhKAzJ6/t7gRzelZKBF7I8Wl" +
                                                                  "FFBdXN26131tatvG1J9/JVp9YpXeZeXp49LVC/veOrH4PFzx5g6QGnAgy4kO" +
                                                                  "eceUOsKkCSNGGmWzLwdHBCkyVTx1uglRmuKNTdjFNmdjfhZ/OeCks7hFKf69" +
                                                                  "Ba5Fk8zo0bJq0q70c90Zz0+nDthndd3H4M4UtHEpCzHRG9CcxCODuu50cOQ+" +
                                                                  "XcTyeKkUsy6hz4tXHL77H15Z76i9GAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1470933729000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "h2/7nee/VhT2/g+Z5wtmGiIAAA==");
    }
    GameBoyPrinter() { super();
                       window = new GameBoyPrinter.GameBoyPrinterWindow(
                                  "Game Boy Printer");
                       window.show();
                       bufferFillPos = 0;
                       bufferEmptyPos = 0;
                       dataSize = 640;
                       for (int r = 0; r <
                                         IMAGE_WIDTH *
                                         IMAGE_HEIGHT;
                            r++) { imageData[r] =
                                     -16777216;
                       }
                       source = new java.awt.image.MemoryImageSource(
                                  IMAGE_WIDTH,
                                  IMAGE_HEIGHT,
                                  new java.awt.image.DirectColorModel(
                                    32,
                                    16711680,
                                    65280,
                                    255,
                                    -16777216),
                                  imageData,
                                  0,
                                  IMAGE_WIDTH);
                       source.setAnimated(
                                true);
                       source.newPixels();
                       image = window.createImage(
                                        source);
                       window.setImage(image);
                       tileX = 0;
                       tileY = 1; }
    void setDmgcpu(Dmgcpu d) { cpu = d; }
    void send(byte b) { java.lang.System.
                          out.print(b + " ");
                        cpu.ioHandler.registers[1] =
                          0;
                        cpu.ioHandler.registers[2] &=
                          127;
                        cpu.triggerInterruptIfEnabled(
                              cpu.
                                INT_SER);
                        buffer[bufferFillPos++] =
                          JavaBoy.
                            unsign(
                              b);
                        if (bufferFillPos ==
                              BUFFER_SIZE) {
                            bufferFillPos =
                              0;
                        }
                        checkPackets(); }
    int bytesAvailable() { if (bufferFillPos >
                                 bufferEmptyPos) {
                               return bufferFillPos -
                                 bufferEmptyPos;
                           }
                           else {
                               return BUFFER_SIZE -
                                 bufferEmptyPos +
                                 bufferFillPos;
                           } }
    short getByte(int pos) { return buffer[(bufferEmptyPos +
                                              pos) %
                                             BUFFER_SIZE];
    }
    void consumeByte(int num) { java.lang.System.
                                  out.println(
                                        "Bytes consumed: " +
                                        num);
                                bufferEmptyPos =
                                  (bufferEmptyPos +
                                     num) %
                                    BUFFER_SIZE;
    }
    void scrollImage() { for (int y = 0; y <
                                           IMAGE_HEIGHT -
                                           8;
                              y++) { for (int x =
                                            0;
                                          x <
                                            IMAGE_WIDTH;
                                          x++) {
                                         imageData[y *
                                                     IMAGE_WIDTH +
                                                     x] =
                                           imageData[(y +
                                                        8) *
                                                       IMAGE_WIDTH +
                                                       x];
                                     } } }
    void checkPackets() { if (getByte(0) ==
                                136) { if (bytesAvailable(
                                             ) >=
                                             3 &&
                                             getByte(
                                               1) ==
                                             51) {
                                           switch (getByte(
                                                     2)) {
                                               case 1:
                                               case 2:
                                               case 15:
                                                   {
                                                       if (bytesAvailable(
                                                             ) ==
                                                             10) {
                                                           consumeByte(
                                                             10);
                                                       }
                                                       break;
                                                   }
                                               case 4:
                                                   {
                                                       if (bytesAvailable(
                                                             ) ==
                                                             6) {
                                                           dataSize =
                                                             (getByte(
                                                                5) <<
                                                                8) +
                                                               getByte(
                                                                 4);
                                                           java.lang.System.
                                                             out.
                                                             println(
                                                               "Data size set to " +
                                                               dataSize);
                                                           consumeByte(
                                                             6);
                                                       }
                                                       break;
                                                   }
                                           }
                                       } }
                          else {
                              if (bytesAvailable(
                                    ) ==
                                    16 &&
                                    dataSize >
                                    0) {
                                  for (int offs =
                                         0;
                                       offs <
                                         8;
                                       offs++) {
                                      int b1 =
                                        getByte(
                                          offs *
                                            2);
                                      int b2 =
                                        getByte(
                                          offs *
                                            2 +
                                            1);
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  0] =
                                        palette[((b1 &
                                                    128) >>
                                                   6) +
                                                  ((b2 &
                                                      128) >>
                                                     7)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  1] =
                                        palette[((b1 &
                                                    64) >>
                                                   5) +
                                                  ((b2 &
                                                      64) >>
                                                     6)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  2] =
                                        palette[((b1 &
                                                    32) >>
                                                   4) +
                                                  ((b2 &
                                                      32) >>
                                                     5)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  3] =
                                        palette[((b1 &
                                                    16) >>
                                                   3) +
                                                  ((b2 &
                                                      16) >>
                                                     4)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  4] =
                                        palette[((b1 &
                                                    8) >>
                                                   2) +
                                                  ((b2 &
                                                      8) >>
                                                     3)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  5] =
                                        palette[((b1 &
                                                    4) >>
                                                   1) +
                                                  ((b2 &
                                                      4) >>
                                                     2)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  6] =
                                        palette[((b1 &
                                                    2) >>
                                                   0) +
                                                  ((b2 &
                                                      2) >>
                                                     1)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  7] =
                                        palette[((b1 &
                                                    1) <<
                                                   1) +
                                                  ((b2 &
                                                      1) >>
                                                     0)];
                                  }
                                  dataSize -=
                                    16;
                                  tileX++;
                                  if (tileX ==
                                        IMAGE_WIDTH >>
                                        3) {
                                      tileX =
                                        0;
                                      tileY++;
                                      if (tileY *
                                            8 ==
                                            IMAGE_HEIGHT -
                                            8) {
                                          scrollImage(
                                            );
                                          tileY--;
                                      }
                                  }
                                  consumeByte(
                                    16);
                                  source.
                                    newPixels(
                                      );
                                  window.
                                    repaint(
                                      );
                              }
                              else
                                  if (dataSize ==
                                        0) {
                                      consumeByte(
                                        1);
                                  }
                          } }
    void shutDown() { window.hide(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QdHR+QdV/GS1KfUfiaVC/BopAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C8zr1n2f7vXj2o7te+0kTurG75t2DtMrSpREKk6diBRF" +
       "USL1JiWyjxu+xTdFUqTIzGmSYYvXAqnROVkCJEbRuXtkbtMVKzas6OCh29qu" +
       "RYYU3bANWJMVA5YsyxAPWFo027pDSd/zft+9vrP3AeeIPOd//vz9zvmf//nz" +
       "8Hyvfbd0VxSWoMB3MsPx42vaJr5mOfVrcRZo0bUeUx9JYaSphCNF0QyUXVee" +
       "/rXL3//BS8srF0t3i6V3Sp7nx1Js+l400SLfSTSVKV0+KiUdzY3i0hXGkhKp" +
       "vI5Np8yYUfwcU3rHsaZx6SpzAKEMIJQBhPIWQrl1JAUaPaB5a5coWkheHK1K" +
       "nyhdYEp3B0oBLy49dVJJIIWSu1cz2jIAGu4p7nlAatt4E5aePOS+43wD4c9B" +
       "5Zf/5k9f+fU7SpfF0mXTmxZwFAAiBg8RS/e7mitrYdRSVU0VSw95mqZOtdCU" +
       "HDPf4hZLD0em4UnxOtQOO6koXAdauH3mUc/drxTcwrUS++EhPd3UHPXg7i7d" +
       "kQzA9ZEjrjuGnaIcELzPBMBCXVK0gyZ32qanxqUnTrc45Hi1DwRA00uuFi/9" +
       "w0fd6UmgoPTwbuwcyTPK0zg0PQOI3uWvwVPi0qPnKi36OpAUWzK063Hpvafl" +
       "RrsqIHXvtiOKJnHp3afFtprAKD16apSOjc93Bx/+7Me9rndxi1nVFKfAfw9o" +
       "9PipRhNN10LNU7Rdw/s/wHxeeuS3XrxYKgHhd58S3sn8o7/8xkc/+Pjrv7uT" +
       "+eEzZIaypSnxdeVV+cGvv494tnlHAeOewI/MYvBPMN+a/2hf89wmADPvkUON" +
       "ReW1g8rXJ/9S+ORXtO9cLN1Hl+5WfGftAjt6SPHdwHS0kNI8LZRiTaVL92qe" +
       "Smzr6dIlcM2YnrYrHep6pMV06U5nW3S3v70HXaQDFUUXXQLXpqf7B9eBFC+3" +
       "15ugtP+7C6Ty/nr7G5c+VF76rlYOzPIo9AvqUVnzYhl067JcGIrsZ+UoVMoU" +
       "MB7cz0bh1h6vFVXBW2q9KbBdSS9cAN32vtOT1gH23vUdVQuvKy+vcfKNX73+" +
       "+xcPjXjPKi49eFJv6cKFrbp3Ffp3IwD6zwYzEfio+5+d/lTvYy8+fQcY+iC9" +
       "E5AvRMvnu0riaO7SWw+lAAMqvf6F9FP8z8AXSxdP+rwCEyi6r2g+KjzVoUe6" +
       "etrWz9J7+TPf+v5XP/+Cf2T1J5zofjLe2LKYTE+f7r3QVzQVuKcj9R94UvqN" +
       "67/1wtWLpTvBDAVeKZaAFYEJ//jpZ5yYVM8dOKiCy12AsO6HruQUVQde5b54" +
       "GfrpUcl2WB/cXj9U9HFhZZdB+qm92W1/i9p3BkX+rp0ZFIN2isXWAf74NPjy" +
       "v/vat5Ftdx/4ysvHVp+pFj93bH4Wyi5vZ+JDRzYwCzUNyP3HL4z+xue++5mf" +
       "2BoAkHjmrAdeLXICzEswhKCb/+rvrv79N/741T+6eGg0pc1Jbhduwg085EeO" +
       "YIBp7YAZUhjLVc5zfdXUTUl2tMI4/9fl91d+47999spu+B1QcmA9H7y1gqPy" +
       "H8JLn/z9n/7Tx7dqLijFsnLUVUdiO1/1ziPNrTCUsgLH5lN/+NgXf0f6MvB6" +
       "wNNEZq7tnMeeegHq2pb/s9v8x07VwUX2RHTc5k9Oq2PL/3XlpT/63gP89/7p" +
       "G1u0J+OH40PMSsFzO6sqsic3QP17Tk/wrhQtgVzt9cFPXnFe/wHQKAKNClg0" +
       "o2EIvMjmhEHspe+69B/+2W8/8rGv31G62Cnd5/iS2pG2c6t0LzBqLVoCB7QJ" +
       "PvLR3eCm94DsypZq6QbyO6N47/buYQDw2fPdSqdY/o9m5nv/fOjIn/6TP7uh" +
       "E7YO5YxV71R7sfzalx4lnv/Otv3RzC5aP7650bOCUOmobfUr7v+8+PTd/+Ji" +
       "6ZJYuqLs4zBectbFfBFB7BEdBGcgVjtRfzKO2C2azx16rved9irHHnvapxx5" +
       "dHBdSBfX951yI5eKXn4CJHg/1eDTbmTr+HdjXEC6RoMFwdDCh//kF1/90099" +
       "BrtYGPRdSQEd9MqVI7nBugj3/tprn3vsHS9/8+e287xU+uRW9fPbxz+1za8W" +
       "2Y/ulo0YEDA9ydl7gr8AfxdA+j9FKmAVBbvF9WFiv8I/ebjEB2DZegfOdTrk" +
       "5PqUFsmbGwtY2Fzg2JJ9iFN+4eFv2F/61q/swpfTlnFKWHvx5Z/9i2ufffni" +
       "saDxmRvituNtdoHjtusfKLJOMdeeutlTti06/+WrL/zm333hMztUD58MgUgQ" +
       "4f/Kv/3ff3DtC9/8vTNW8DvAwr1bAYq8UmQf2fVr7dyJ1zxpFo+BVNmbReUM" +
       "syguClW/WFxMzxnT4pLcMu+A8aHZFkVen9PtWbcoYk4hnN0mwsdBqu4RVs9H" +
       "eOGjxcVPvBmE9+8Qdkma6s7OgviTtwmxC1JtD7F2A8TS9kJ5M8guBZKjxbEG" +
       "LOf959v1dsHZmekrf/uZr/3MK8/8p63PvseMgKtohcYZ7wjH2nzvtW985w8f" +
       "eOxXt+HMnbIU7ZzG6ZerG9+dTrwSbSHff7If7gNp32W737hUf5MxLiGF4HVK" +
       "NbSD4Pj/reEWFRMEQenUkKpvfkgvHMyLxp5K45whDc4e0tLBaN6dgvntp9v6" +
       "dwP3cTLevnrydr6VPYV6dZuo7wcJ3aNGz0Gd3QL1HUqwPoB8d9s1wO0pVPlt" +
       "onoWJGyPCjsH1adv1ZfyWgex9bZ+eVL93TdTvxWl9/64+GHBAgSCkzA+w0j+" +
       "ym0SeydIzf2Tm+cQ++wtiD2wI9YxHQe88J7ljX7+NlG9C6QP7VF96BxUn7sF" +
       "qgd3qEg3iLNzYH3+NmE9DNKH97A+fA6sL90C1l1gUdQWZ6H58v8HNH/rzaAR" +
       "zkLz6m2ieRCk5/donj8HzVdugeYeVYqlKXjpOAvQ379NQI+WTnnyMwD9g1tN" +
       "2chfh/vVA/iSJ7dho5TG10xXAu6a1Vw/zOjieroVPAX5128T8gMgtfaQW+dA" +
       "/ie3GtEttAPEDx4i3qI8he83bxNf4Y/xPT78HHy/fQt8927xtcFAFwXWKUT/" +
       "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" +
       "NxzGPNnouZPHHO4LtXgderMThx0eO7nX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+kMgJfueTU7vtR6N3Xkbrdvio0M6F46+1H5iK/D9UwLHT/H8WZG9Afo/0uLd" +
       "17Mztw8T31SP7Od/3Grn8PhTtgX//cbPGfmecP52ET4TuJzF283WC3ed3wkX" +
       "7iuyEpCONE8tBP78kOuFC2+Ba3EEc/vV7cU91xffMtfjsN91k7pHiuxy8WUM" +
       "dEDUSqQi1NqdHWWOyF15C+S2n9CLL0Ev7cm99HZaLrNl8eRNGD5dZD8cly4Z" +
       "WowDkoXMXz+i9r63aqPFN6WX99RefvupffAm1K4V2Y/GpXcUx7DWrnZA75hZ" +
       "/qW3Sq8wyy/u6X3xbTVL7CZ1HyoyBDCLlNB3nMMPVceY1d4qs+KD8i/tmf3S" +
       "28qsfZO6TpF9JC7dryw1xS6OyGu7/3I4Ru2jb5VaIfvtPbVvv63URjepmxRZ" +
       "PwbL8XIdt/3UO0WLuR1amxtOcgfBwUe4e4qK4pDn5sLJgOLgUaWHb/WoYzHI" +
       "Mycih+1/lBys8uvd/5RcV776Sm/w8Tcav7w7c6w4Up4XWu5hSpd2x58PI4Wn" +
       "ztV2oOvu7rM/ePDX7n3/QVTz4A7w0bAcw/bE2Sd9twcYirO5+T9+zz/88N95" +
       "5Y+3ZxT/L4A+NxrqMwAA");
}
