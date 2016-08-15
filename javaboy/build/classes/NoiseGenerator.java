class NoiseGenerator {
    public static final int CHAN_LEFT = 1;
    public static final int CHAN_RIGHT = 2;
    public static final int CHAN_MONO = 4;
    int totalLength;
    int cyclePos;
    int cycleLength;
    int amplitude;
    int channel;
    int sampleRate;
    int initialEnvelope;
    int numStepsEnvelope;
    boolean increaseEnvelope;
    int counterEnvelope;
    boolean[] randomValues;
    int dividingRatio;
    int polynomialSteps;
    int shiftClockFreq;
    int finalFreq;
    int cycleOffset;
    public NoiseGenerator(int waveLength, int ampl, int chan, int rate) {
        super(
          );
        cycleLength =
          waveLength;
        amplitude =
          ampl;
        cyclePos =
          0;
        channel =
          chan;
        sampleRate =
          rate;
        cycleOffset =
          0;
        randomValues =
          (new boolean[32767]);
        java.util.Random rand =
          new java.util.Random(
          );
        for (int r =
               0;
             r <
               32767;
             r++) {
            randomValues[r] =
              rand.
                nextBoolean(
                  );
        }
        cycleOffset =
          0;
    }
    public NoiseGenerator(int rate) { super();
                                      cyclePos = 0;
                                      channel = CHAN_LEFT | CHAN_RIGHT;
                                      cycleLength = 2;
                                      totalLength = 0;
                                      sampleRate = rate;
                                      amplitude = 32;
                                      randomValues = (new boolean[32767]);
                                      java.util.Random rand = new java.util.Random(
                                        );
                                      for (int r = 0; r < 32767; r++) {
                                          randomValues[r] =
                                            rand.
                                              nextBoolean(
                                                );
                                      }
                                      cycleOffset = 0; }
    public void setSampleRate(int sr) { sampleRate = sr; }
    public void setChannel(int chan) { channel = chan; }
    public void setEnvelope(int initialValue, int numSteps, boolean increase) {
        initialEnvelope =
          initialValue;
        numStepsEnvelope =
          numSteps;
        increaseEnvelope =
          increase;
        amplitude =
          initialValue *
            2;
    }
    public void setLength(int gbLength) { if (gbLength == -1) { totalLength =
                                                                  -1;
                                          }
                                          else {
                                              totalLength =
                                                (64 -
                                                   gbLength) /
                                                  4;
                                          } }
    public void setParameters(float dividingRatio, boolean polynomialSteps,
                              int shiftClockFreq) { this.dividingRatio =
                                                      (int)
                                                        dividingRatio;
                                                    if (!polynomialSteps) {
                                                        this.
                                                          polynomialSteps =
                                                          32767;
                                                        cycleLength =
                                                          32767 <<
                                                            8;
                                                        cycleOffset =
                                                          0;
                                                    }
                                                    else {
                                                        this.
                                                          polynomialSteps =
                                                          63;
                                                        cycleLength =
                                                          63 <<
                                                            8;
                                                        java.util.Random rand =
                                                          new java.util.Random(
                                                          );
                                                        cycleOffset =
                                                          (int)
                                                            (rand.
                                                               nextFloat(
                                                                 ) *
                                                               1000);
                                                    }
                                                    this.shiftClockFreq =
                                                      shiftClockFreq;
                                                    if (dividingRatio ==
                                                          0) dividingRatio =
                                                               0.5F;
                                                    finalFreq = (int)
                                                                  (4194304 /
                                                                     8 /
                                                                     dividingRatio) >>
                                                                  shiftClockFreq +
                                                                  1;
    }
    public void play(byte[] b, int length, int offset) {
        int val;
        if (totalLength !=
              0) {
            totalLength--;
            counterEnvelope++;
            if (numStepsEnvelope !=
                  0) {
                if (counterEnvelope %
                      numStepsEnvelope ==
                      0 &&
                      amplitude >
                      0) {
                    if (!increaseEnvelope) {
                        if (amplitude >
                              0)
                            amplitude -=
                              2;
                    }
                    else {
                        if (amplitude <
                              16)
                            amplitude +=
                              2;
                    }
                }
            }
            int step =
              finalFreq /
              (sampleRate >>
                 8);
            for (int r =
                   offset;
                 r <
                   offset +
                   length;
                 r++) {
                boolean value =
                  randomValues[cycleOffset +
                                 (cyclePos >>
                                    8) &
                                 32767];
                int v =
                  value
                  ? amplitude /
                  2
                  : -amplitude /
                  2;
                if ((channel &
                       CHAN_LEFT) !=
                      0)
                    b[r *
                        2] +=
                      v;
                if ((channel &
                       CHAN_RIGHT) !=
                      0)
                    b[r *
                        2 +
                        1] +=
                      v;
                if ((channel &
                       CHAN_MONO) !=
                      0)
                    b[r] +=
                      v;
                cyclePos =
                  (cyclePos +
                     step) %
                    cycleLength;
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "V/78tpqCZvAZraQkpUhbU7Q14ewRoiIj1edQlh2u8AIna6gYRiKLQAdYsMzO" +
       "+O+lHNX5WWyEYyO8rgWzBYbTk7o154iDe8XbXv24fN3HT53i3LsDaafjaBM0" +
       "U/TVmJ2Foj/Du9K1CMYgtLvoWPuGKvnY59BjD/QoQvRodOiwnKZdbsZqXTTu" +
       "9784PmXTywUk2kxKZVVINAvcY5Px4CqpMQgrcVpbdanpKbahg6zirJIc5nMK" +
       "cLbO9vcDTUmN8Zm7/fEzfrri0IG3uMvSeBczc92xYXkqw98dY342ZufmOrkg" +
       "Uo8GLeuyVXx1iIp7MOvmVa2YrTV5j49RTFjQpZkV03khrjAzXOEJ34raK+Th" +
       "Vy75zaHv7d9mzqoQH+Ghm/rvDrnv5nc/yzE3HhD4uA0PfU/syF3TGlee5PT2" +
       "yozUtencYA6iG5t2yeHkP6Pzin8ZJeN6SJVobf3WCXIK17se2O4Ymf0gbA9d" +
       "9e6tixmn12cjjxlev+UY1hsTON1BIXNNfTsMmIx6ORvSEst4lnjtjsea5mxC" +
       "SHWtsFMboHrNuz86+OlNO5dFcR0qGkLoIJUqu117CneYtx7ZN7Ns7zvf5Uaf" +
       "Mbt+04x5vgiz87gpFOBnHSzjBt+sMmBHUgTZs5xPCgHLyPjGlob23nhT89qs" +
       "H5toW+/AaNa7yS2YcyAttcZa6iMY/BiE4ih+GGFcYZbETPFhJ2gIRko5O12t" +
       "l7f48sPy5AcVvcwabFkIP4X4cf2Y+QkaIqOeto72Dj92dnx5dvhY1ZDqrbHq" +
       "c9gh/OMWfy6IB3YkpCtGyhg4Dxl2KgPmZtML/NY8gVdAWmGNtiIA+C7b14/k" +
       "Yg2iZqREHBZlCntyP6C7xyDhVdZQqwKA7g0FGkQNQuVAg4W6L0+slZBWW6Ot" +
       "DsD6w1CsQdRgtwIeerJUgvohvStPpOWQmqyxmgKQ3hOKNIiakXHiIKx1VPbD" +
       "eW+eOLGqxRqpJQDnA6E4g6jBsxkoUtoF4b8f1MN5QkX3doU12BUBUB8OhRpE" +
       "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" +
       "fu3/P/KHnbPlLAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bkHy+Mk8euZWvTyr6Qn27201/HB+0NvMD55HSFH0XB51t8Cff100bus+Wjw9" +
       "cntt6ufu4qElf/R/k7b08T//X7dMdLEAnaJgJ9oLwCu/8BjyY98u2h+uBHnr" +
       "J5JbV+LMtT5sW/s1539eeOqe371QulcoXZV3fjsn2nFuX4XMVw33nfnMtz9W" +
       "ftzv3DpZNw9Wunec1PAjw55cgw41K0vntfP0pRPLzsM5l384C7XdzNdOCk3h" +
       "KGzlOId0A8vcbF0Nrv35L33xrz/2ieaF3O7dvcqhZ1y5elhvHOfbg5965bOP" +
       "v+Wlb/5MsS7sywyzlcEivp5HP1zM71158t3ZshEWO40oI8d0RbtADEal+xG0" +
       "PX5h1OszB8bh6qFUsXeSKvI4ze/OArSjGTqF5jzB5b5Pnvjg7QDn0fvy6P37" +
       "SC8VSGlsgJ4KVTwn1Hx6mjuozdtAvZgnjPNB3TKVIMfkaUjN14+0MCF54uYO" +
       "6c1bkJaKhH86wNI+ordEmaLaI9XVt175SUzLc2K6nIXndpieOwPT+g6Y7pNT" +
       "2VazTcppgJI3wKTnd4CePwPQR+7EpALQ2Uz66DkxXclCZ4epcwamn7wDpvtF" +
       "x7fNKFbU0xD91DkRPZiF3g5R7wxE//AOiO6Vjczuq/ZpeD55Tjx5EbrDg56B" +
       "52fvgOdSmLNIpTNv6jRIL50TUm4chjtIwzMgff4OkK6Ybua9iXbPXam255+K" +
       "6+fPiSv3QYgdLuIMXP/0DriuZn7iNFL98HbAvnBOYI9lgdoBo84A9it3Ama6" +
       "cqCKoboPrKhZKUq3cBqZ4EmeZ6uiewLvr76BCaZ3eOkz8P7mnSZY9uL8YOx2" +
       "fPwX58T1aBbYHS72DFz/5g64HghEV/GcwucJMw/jmbMdu2Kvtd31vPzPnv7D" +
       "j7789J8VvvZ9Zpi5P+1AP+Wc7Eib777yjW9/7cHHf73Y0l+UsqnLIVw6ecB4" +
       "6/nhsWPBAvcDx/lw3+34kMev+r5fOsHsf3tOZr81C/xuEP4MZv+HOzD7QcVc" +
       "mYrp6nTuAp8mAr/7BkRztkM1OwPVV+4kmvmcuZ6TmZ9C1U/D9dVz4npbFuY7" +
       "XPMzcH3tDrguh4apRYjtyVY/UJenwfpPb2B9FXawhDNg/cmd1tfCGz4L0Z++" +
       "AS/kfTtE7zsD0TdflxeyPW89DdOf3RHT1mzu7WW+fu0GfKMwo39xPg/27Qtb" +
       "vr5/WsGpQZjt8a4vbLho/3B0dEuyPcU/ARJ83SAzK3X5sLOR5+o3f+a/ffqr" +
       "/+jpb2TmCN/fBOW1Mz3d4zYf+si38ofvno+ex3J6pl4cyOpIDCOiOLRSlQOS" +
       "Tiw1F23vTZAUXXsJBUOsvf8bcSJSb3NV2iq3ykJnSpiM0VzAPW4ykROu74l9" +
       "3cQsvL5YOxNl2jaIumrVaAMuN1K11gAnokMNplzUaQrTySDmGlOdFzgkZCsy" +
       "zC1n3WpPrW68BV+1PY0T1Sq71KZMNOOjlQRsyo1WGTbhQa3MbvCUWamqDECb" +
       "lQZtAIBUEggZTwXSsPo2N0fpFb/sozN/1CEnjJIttj2+OyAim+KHUSJjQGsB" +
       "TrRVOkTcGKP5rh71HEQXIntpygQaYEzPSpwhglUHpjvGeqzLeNVlF7SIns2p" +
       "oWGlvDHONtbWdJmMGa4Thj14AjZocd5LZ2V7mA3kKUQX23Qtw0R7TrjmIgVN" +
       "ZYbus1LkR5TC0CtlTOtpY9Kywz7GzdINgTA91kqn8zqKzynOd4U0WGqjtT5M" +
       "U9L3HUVY2b4wx6rhdAZ5hl4PSc6tJ+Varc31m/3ehOuzSWRt4qVppBZR6U1V" +
       "TnEchsGpAbfCItZou8IcHizGzIAAqcF83J538cCoOmC/QcS+ZXm1pb9W7Njx" +
       "+Q5B95Dxpi5UPd0ErYAHGySfOS1zWlihYxNEBdK2YyZN1nwLqki1+gpOlj6K" +
       "WIbdbTisPWj0sDWGdTyqovc6fugBS9oizAlNtPy+1xFmCjOjcUuUYrtB+92B" +
       "3e7Z+qgqNKeIMXXGDTch+Kqo0+XOmAFtoipRYWtGdkMX5FryCmlT7UaiShw0" +
       "agspiHZY3Wk3tApSw6t9NjD6rDEkNpQwFVAnXE0wsU06ID7gu6IrehOLb7dt" +
       "fOF4ejhsk4m0aLeECSL2l7aud71FZY3BNGcHetbPYIi0RHygKn7V6UsTcbPm" +
       "OziWEK2FtKDmA953nQo07lJ0uRIodtmNEIPu6SiBTIOhOWoS5kCAzJHvUS3W" +
       "37RJRiaGZhmFjNQnFiw71Js8Tc1hajxvqVrsMkkwoCiHrzllmPEb44iglXmA" +
       "xmmgovYAbI7szsRc0H1ijAizFehvqNBqBP6iEelzVbDiCj0sh6ktqw03cJ0k" +
       "pCoCPmUjHzdZgWOmErLIloex6ONES479ict3KuwkGLBljkbIlZTOFmA3jIfK" +
       "JITVxWqcGgE+Z9NR6vNlvjlhmVZFn2JLg2/hDU7e1KGg3VnZdd6k+FkysJqN" +
       "6grwy7TUnAyq0+lY5IYhW1VpZUoMNss5lXS9+aRC+SyoLIxcje0ZnknChBOB" +
       "7jCuBKwo07UmHVkTE5PmQr0S+jqc1pbusNMIYL0eSYFf7ZGtEaQPdFYIZZnD" +
       "DCnSep67hk3BABrzwQSFpDkiIkMoXYfUShwL0QAy+HYj4CJD7jT7eEDKaQVf" +
       "aEJloy3ms1XfYzS3FvMtRe4mQyQmLdroCFO/S683mtcut+EEqWcUB5MOGPdh" +
       "iXJJdF0bLcTGMMJ6MbbW67V6ZqcwkqXro4HgWg1ksPHirmxOZrBcBZrQWFdq" +
       "NUhUmhTE0ng1rllyqOvNLo7XPZcak1FfhAGm0oCVFFqrGjquAROYdZfhaiVA" +
       "YoD2AmsuQDOQg5MWtszIN6nWogF5kDjSmDXImmIbnJOUE7PKusyijQVR7s8s" +
       "vz2XYI6p+Gnf5KxZzx+0GE6azfGoSS+BRQXfDLEe3pyz004cOfIImJcrbFcj" +
       "NgwR9UlgvF7P6rUxHFfjOlCv2M0YIkdkTCnDBA5khnNa6wanC5uZrHKMJAQR" +
       "7yeMuJrZKARodU2iN5SkCGIX1aRmR9x0Vh17YjR70Satj6VZvQ4H4HBFB3gV" +
       "HQxTf8mAGKPgAm5SWAXWJ7gzqIS1dRPEccsZV72xxM2GDqKxQdNqERaLtwRg" +
       "aChykzQ0paoKitnpTmWR6HuAqnPVMuT4KbgOJQqq92PQwWKEEYmAlJwZVPOi" +
       "6kZvgKM1qC80hcQdpgVygS5RXQGcspTIBO5iWJ6kQ5ShFCGh6qJVbpdF225P" +
       "qt2+HaT4iGRUHJNUDYZW/trXy50aD6eA1Fca9QZcZvkY6gzlMmeSGi7D0IID" +
       "EUztc4KLAOtRGfO7ZWPt9Bc674wakB91xB6pWNxEoaY6mhjT9sIVTKTmlaVo" +
       "NFNazWEX11Gt3+pOHaweA83KTIGDmgOF6XruwmQaNyyCJUZWUidsk2zE/GAh" +
       "Y4FDJYDSlJkWWRfF5SCQzdqESbA2tVpJWr+8ilVSgdCkpWF9xwBZzouWQgds" +
       "JZtGU7AaI3zFAXAz8peIsGoLgTixfNaQWHhSBdU17ZnYoqoqE9uoxc025ooN" +
       "fU6bw9GkrcxDYkOWybKNjmcQz6e9eUo2A53fdOYSY8FeFQLNrtqcSbNVDdTG" +
       "dZSB6mZ9FHZFUVuIHaLCApl04bW+twC6cWtYRYi5Ho1WHk/Fg+HKnUOtzqIL" +
       "TLzJivYU0ly7Q0GRQmE5Y5i4BTdBypkx6Zq1alYyFDgOG7dX8hyiEhBZ+sRE" +
       "D2TOlxTR9YeSaOiNjRngmAy5xFAeSWRrJXcZ1hk3BQcGtN5GCwKzgg3qMbGa" +
       "qh15I7dqyXxmLdetpjKvgzUh1hwysHTWaw5Gapxys6RqYj5MkKts51qbBwwH" +
       "LcAWzfQXE1+wuErdMoJFezMje3gdDMRhmTG4FIY2IrqClZazWXoTtDwwHCBY" +
       "dQN3BbkykG56ddTognG7QmksEKb9OjOwVRWimFrqbdhIdeV5u2EOoKiWqqhF" +
       "NaiN6TYFXB03pjjnSVqdR2bYsAqHao0E545W0aV2S2mpjchMHLdakxeLxFZX" +
       "ZXZeNUKGHFc72Gw81piQcLCkQdKraS+MQNtdRItQFSEnQaYoH4V9QvLQYBxv" +
       "mo0yaY9JSOnLdGU5sEYehrPLuFqFEVedRwksjOFxCOeuGitqhBSVK2ACrXRz" +
       "04R1v092XHS6WXSicjZgB2V1RgihhEJ0dJRSi4HtZe6FazDN1jJEocjjy0Bb" +
       "HItwOq3N5bQdRbIgNkxiDnTMHmga5cGgL88FqcdQfQOv6RhteRBZrUU2rIHN" +
       "kEqhtsyt5LUo9S2MAmegrNXm5YklYktSjTy41l20aoqbQMrKmFeF7jKQ0KXc" +
       "0g2AJHgtbWCd+tzykWiQGjrYTezaUKccISJGwHje1DmlzTuDcWRi7TICS1UQ" +
       "sOZ6zRSWdA/tCDbiRinVQOAk7RqcIkyW62Eb1iv9gTUZT2KurYN8Y1Qph7bQ" +
       "4fkGGXXDbmNdRcKJQuvRGlPVAGf1lWesphHlk/zEWaaJow8ndYMcjjFTtGao" +
       "iQ2TKkdJXZUvq+RosEzopY9Pum670QP1xqITJpbHRl4flJpalRhDE2tWVzy2" +
       "Wuuw2V9mUWk/E/wu2G/jrQkPTY2lGYoBBGoQ5s70TbW2XNO19WhNGeJwDGZj" +
       "ToO56E42S8M29A5A9YB2ZYrXeQuvdHS8OezQSa87b9u0MvElpLnRu26SCHo0" +
       "rqE8CUMzXUDrS9EnOjK78p3qUN0YLVVPneqAM+BJoLf6quG2hcxZdnBR96k4" +
       "JCrNylBVhwoSR5jYlL32CimjYM5nZ4qMTB0fy9aCXVPmuj3rgIwMeEy7vmwr" +
       "ZYoq24M1TAAppdkQh3X0bKXXlu0NOAD1srTAamWN6vfKzbRf7vVFTFhXME9J" +
       "YAvqwKzabgBltRHU6Q3fwRy0mVIi5A+ongdaojzFrWEjc5mspd62AaTPIizK" +
       "LvCJ6yM9H5ta3ZlkdpoMKYybig7aigRWK4pOiS12RHeqg665HIz7zHzUhXow" +
       "1i0DsKqO+otaHPbEJr6mIiNjti5a8+WiN/DdzWy4DEybFxUJUBEV7RFWxSHG" +
       "tQ7RblUnXh3pLM0eA7qmjjUUAO2Ny1HUFEQU7FbCKmJlezOhTDSaFQrtlpfN" +
       "zAl0AEIaA0EYZhspswlpNKFlxslh0boEpCAcd8fqummRcQPGBp6icOvh2uGX" +
       "ig8Ra0aGYzMYuPba7Q/qMpg5xwAjB61gUw9by05Vc2WX7wpBvx/TQLcuoYhk" +
       "gsNWYGjDcKMA5KAepWF/rHJpN/PZsVRZ2e1aFXUDoDlC+5SdLVZOLE9IRU2l" +
       "JZ5tAu3ukoWEqa3JCQhswnpgC1Vgg2HVuWrUE36JRyTbd2eVgbUazNY1TrUq" +
       "EdWWtTm3nlDYFHHB2aarw05aaRgq1W83fNbEg5owSIMyOekS4SLhQWMz5ytp" +
       "Ga9wAIQgJqYwrLmZgJNKHx77A6LFVP2FolpMqNINQQuWVjiRpqgX25lkjTAw" +
       "E79a2tFU33DBigbB61XX741cv9Pb6PMVguIJjUbkWkg2sU4zSNkmTTiEm4lC" +
       "9EjbEwKsSXfW4HyKzfS51q8BG8KOmv5iyLvTRJewcXUhz2gKCDEMW/F1K+rV" +
       "RtasFZqBNaMYnalTkhylvOCS2HgcrsVNu9Wra04fw811StFVURl5hoKoITZN" +
       "EwqabqbYuIeYga5EtUk0TJqQMWlZGyZZ1YHYopvgqA0DAdMEGQewCBs0VrjQ" +
       "gqkRlc7isSO1By62DhcAAY8q0w3YFmm64lsx3hZ8iGSw2sQmpKCBeuMGjRIN" +
       "F1k5/YCVl8lwUPYHk4FYF4LObMroQxzURGrcnXn8SOxai2Q2qvkD0GZXwlJZ" +
       "tehGg8UBHx4GaBRoetiWJQ5pTrwmW1PLvI+ycZxsiMaiQtOeP/bRdE2v+UQb" +
       "9Jg2uPCRRn+gmva0R8u4EWbzO16FmAkkI3kKlTkfJ2lnNMNaQlTTqUqFNxZV" +
       "plWOIUGOIJJnFNLDeJSSK5DBMWSMke5iPElJhva6CxPWnJjEeUAgEiIRGMgO" +
       "+jMK9XVGi6p+2ihv6msQCwOkFdfn08QOIaJSH40dUBlAugQ5ZdMOec2Gkyal" +
       "9525LUuTYW2mdCrZ5hocdCi6iUM1J1Y4gxtIGrdJymGPY4Bqw6eMnt1jeAvM" +
       "jE6wLrc2WByInD6B22XXDavdTa+plSF6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("BXRJUOBHZQCo0SuJT+t1vMHXtSEMNRpjf9ay1i0SiYap7eM9PiFFPNB6NlgL" +
       "UJqW2cUKU/lpRZgMzHF7xHRWs9Ws2U/iCbJyUUvOdii8AEYJr6ALYjPStOGk" +
       "XDUDri/W2Vmt6tjYtNarQDCChla4KSedmehvmPGkhsz4YdADuiNGFNw4Grbr" +
       "9aXgO7Rs+D1q0Y9ClhyyZhnQXS3bhFDAEHUlyh612+38eOr75zs2e6g4Bjy4" +
       "2buw4bzgL89xMpacddp5cHB68Dt2NfTIwWlR89H9ZkHp8bNu7xYXpb748Zde" +
       "Vshfrl7YnajCUen+yPN/NPPVVPtIV/dkPb3n7NcjRPGW4vDyye99/H88xvyY" +
       "8cFz3Lx85wmcJ7v8VeKVPxj8kPyZC6W7Dq6i3HKt+nijm8cvoFwK1CgOXObY" +
       "NZTHDzhb3F16Kgsv7jj74skj6cOJvGWGijsl794KQlF29kWlvWsnKhy5qLT3" +
       "tjx6MCo9GKrR9OBN7amHrivPVA6kau/yeW405Rl7l45T/mQWPrmj/JN/S5Q/" +
       "eRvKn86jd+QvqNUIOXhnvvfIIYmPv1kS8Sx8ZkfiZ34wJN51aBDqB9GrBUE/" +
       "ehtigTx6d1R6S0bskbeiR6l99s1Sez0Ln99R+/m/pQlt3YbG/E7kXv7OKL/5" +
       "vn9L5CiF0Jul8P1Z+MKOwi/8QOfzNIW7W7M9sXjH9OohA3q3YUB+6XDvvVtd" +
       "LmydGqnFlyVHmdB+s0yoZ+HLOyZ8+QfPhN85GO1a3nl+r+Lru9GK/1Hp+df5" +
       "WcF0GYuByourW79MeLNdJKcaSCndWc4jonvw6mmP271h3Pvx0/lTXLorFvmD" +
       "9f0e+9hlpz3WTw76v7D7SiF/fjjaXdMuXtIhtueq+Y3v/bLtFw+md+PgU6Ws" +
       "MDkN6d6lLdJisC3MPHrmtEk7KnmL25QVVlXPxFnOcW3JuE11LykdGrcih7lN" +
       "7fy18B6Z8d63xfSEpFPnunN7y/civn/K29Tt3dRk77jTsz9k6dqdhjziJz19" +
       "zLspvl/b90Ti7RdsL8hfehkff+h7jV/efuEg2+Jmk/dy36h07/ZjiwNv5skz" +
       "e9vv6x702e9f/o37n9n3vC5vAR9q7BFs7zz9c4Ke40fFBwCbf/32f/ncP3/5" +
       "68UN1/8P41l9+Fg4AAA=");
}
