package org.apache.batik.svggen.font.table;
public class GlyfSimpleDescript extends org.apache.batik.svggen.font.table.GlyfDescript {
    private int[] endPtsOfContours;
    private byte[] flags;
    private short[] xCoordinates;
    private short[] yCoordinates;
    private int count;
    public GlyfSimpleDescript(org.apache.batik.svggen.font.table.GlyfTable parentTable,
                              short numberOfContours,
                              java.io.ByteArrayInputStream bais) {
        super(
          parentTable,
          numberOfContours,
          bais);
        endPtsOfContours =
          (new int[numberOfContours]);
        for (int i =
               0;
             i <
               numberOfContours;
             i++) {
            endPtsOfContours[i] =
              bais.
                read(
                  ) <<
                8 |
                bais.
                read(
                  );
        }
        count =
          endPtsOfContours[numberOfContours -
                             1] +
            1;
        flags =
          (new byte[count]);
        xCoordinates =
          (new short[count]);
        yCoordinates =
          (new short[count]);
        int instructionCount =
          bais.
          read(
            ) <<
          8 |
          bais.
          read(
            );
        readInstructions(
          bais,
          instructionCount);
        readFlags(
          count,
          bais);
        readCoords(
          count,
          bais);
    }
    public int getEndPtOfContours(int i) { return endPtsOfContours[i];
    }
    public byte getFlags(int i) { return flags[i]; }
    public short getXCoordinate(int i) { return xCoordinates[i]; }
    public short getYCoordinate(int i) { return yCoordinates[i]; }
    public boolean isComposite() { return false; }
    public int getPointCount() { return count; }
    public int getContourCount() { return getNumberOfContours(); }
    private void readCoords(int count, java.io.ByteArrayInputStream bais) {
        short x =
          0;
        short y =
          0;
        for (int i =
               0;
             i <
               count;
             i++) {
            if ((flags[i] &
                   xDual) !=
                  0) {
                if ((flags[i] &
                       xShortVector) !=
                      0) {
                    x +=
                      (short)
                        bais.
                        read(
                          );
                }
            }
            else {
                if ((flags[i] &
                       xShortVector) !=
                      0) {
                    x +=
                      (short)
                        -((short)
                            bais.
                            read(
                              ));
                }
                else {
                    x +=
                      (short)
                        (bais.
                           read(
                             ) <<
                           8 |
                           bais.
                           read(
                             ));
                }
            }
            xCoordinates[i] =
              x;
        }
        for (int i =
               0;
             i <
               count;
             i++) {
            if ((flags[i] &
                   yDual) !=
                  0) {
                if ((flags[i] &
                       yShortVector) !=
                      0) {
                    y +=
                      (short)
                        bais.
                        read(
                          );
                }
            }
            else {
                if ((flags[i] &
                       yShortVector) !=
                      0) {
                    y +=
                      (short)
                        -((short)
                            bais.
                            read(
                              ));
                }
                else {
                    y +=
                      (short)
                        (bais.
                           read(
                             ) <<
                           8 |
                           bais.
                           read(
                             ));
                }
            }
            yCoordinates[i] =
              y;
        }
    }
    private void readFlags(int flagCount, java.io.ByteArrayInputStream bais) {
        try {
            for (int index =
                   0;
                 index <
                   flagCount;
                 index++) {
                flags[index] =
                  (byte)
                    bais.
                    read(
                      );
                if ((flags[index] &
                       repeat) !=
                      0) {
                    int repeats =
                      bais.
                      read(
                        );
                    for (int i =
                           1;
                         i <=
                           repeats;
                         i++) {
                        flags[index +
                                i] =
                          flags[index];
                    }
                    index +=
                      repeats;
                }
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e) {
            java.lang.System.
              out.
              println(
                "error: array index out of bounds");
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0aCXDc1PXv2rEdH/GRO7GdywmTAy9XWoIJxXHsxHSdmDi4" +
                                                              "4EAcrfbvrhKtJKS/9jo0BUIpoZ0ygYZwDGQ609AADYQyhTbD0bS0AQbKDIGW" +
                                                              "UoarF7Q0LelBO6Qtfe9/aaXVHsakZmf0pf3/v//ffXzp4HEywTJJM9VYKxsx" +
                                                              "qNXaqbFeybRotEOVLGsj9A3Kt5VIf9v87roVQVI2QCYlJKtHlizapVA1ag2Q" +
                                                              "JkWzmKTJ1FpHaRQhek1qUXNIYoquDZCpitWdNFRFVliPHqU4oV8yw6ReYsxU" +
                                                              "IilGu+0FGGkKAyYhjkmo3T/cFibVsm6MuNNneKZ3eEZwZtLdy2KkLrxVGpJC" +
                                                              "KaaoobBisba0SZYaujoSV3XWStOsdau63GbBReHlOSyY/1DtByd3J+o4CyZL" +
                                                              "mqYzTp61gVq6OkSjYVLr9naqNGldSb5ESsKkyjOZkZaws2kINg3Bpg617izA" +
                                                              "voZqqWSHzslhzkplhowIMTIvexFDMqWkvUwvxxlWqGA27RwYqJ2boVZQmUPi" +
                                                              "rUtDe27bXPdwCakdILWK1ofoyIAEg00GgKE0GaGm1R6N0ugAqddA2H3UVCRV" +
                                                              "2W5LusFS4prEUiB+hy3YmTKoyfd0eQVyBNrMlMx0M0NejCuU/W9CTJXiQOs0" +
                                                              "l1ZBYRf2A4GVCiBmxiTQOxukdJuiRRmZ44fI0NjyeZgAoOVJyhJ6ZqtSTYIO" +
                                                              "0iBURJW0eKgPVE+Lw9QJOiigycisgosirw1J3ibF6SBqpG9erxiCWRM5IxCE" +
                                                              "kan+aXwlkNIsn5Q88jm+7vybrtLWakESAJyjVFYR/yoAavYBbaAxalKwAwFY" +
                                                              "vSS8V5r2xK4gITB5qm+ymPP9L564cFnzkWfEnNl55qyPbKUyG5T3Rya92Nix" +
                                                              "eEUJolFh6JaCws+inFtZrz3SljbAw0zLrIiDrc7gkQ1HL7vmfvpekFR2kzJZ" +
                                                              "V1NJ0KN6WU8aikrNNVSjpsRotJtMpFq0g493k3J4DisaFb3rYzGLsm5SqvKu" +
                                                              "Mp3/BxbFYAlkUSU8K1pMd54NiSX4c9oghJTDRarhmk3Ej98ZSYQSepKGJFnS" +
                                                              "FE0P9Zo60m+FwONEgLeJUAS0flvI0lMmqGBIN+MhCfQgQZ2BoXicaqGYjh5K" +
                                                              "iqg0tEYdifUp4ArpamrJpmKA0wGNMz7FvdJI9+ThQABE0uh3CCrY0lpdjVJz" +
                                                              "UN6TWtV54sHB54SyoYHYHGNkOWzfKrZv5du3iu1bcftWvn1r7vYkEOC7TkE0" +
                                                              "hBKACLeBMwBvXL2474qLtuyaXwLaZwyXAv9x6vysqNThegzHzQ/Khxpqts97" +
                                                              "48yngqQ0TBokmaUkFYNMuxkH9yVvsy28OgLxyg0bcz1hA+Odqcs0Cl6rUPiw" +
                                                              "V6nQh6iJ/YxM8azgBDU031DhkJIXf3Lk9uFr+68+I0iC2ZECt5wATg7Be9G/" +
                                                              "Z/x4i99D5Fu39oZ3Pzi0d4fu+oqs0ONEzBxIpGG+Xy/87BmUl8yVHhl8YkcL" +
                                                              "Z/tE8OVMAtsDN9ns3yPLFbU5bh1pqQCCY7qZlFQccnhcyRKmPuz2cIWt589T" +
                                                              "QC2q0Dab4FpgGyu/4+g0A9vpQsFRz3xU8LCxss+4+5cv/OFszm4nwtR6UoM+" +
                                                              "yto8Xg0Xa+D+q95V240mpTDv9dt7v3Hr8Rs2cZ2FGQvybdiCbQd4MxAhsPn6" +
                                                              "Z6589c039r8cdPWcQVhPRSA7SmeIxH5SWYRI2G2Riw94RRW8BWpNyyUa6KcS" +
                                                              "U9AI0bD+XbvwzEf+dFOd0AMVehw1Wjb6Am7/zFXkmuc2/7OZLxOQMSq7PHOn" +
                                                              "CVc/2V253TSlEcQjfe2xpjuelu6GoAGO2lK2U+57SzgPSjjlMxhZ9jE9y0Z8" +
                                                              "ynYQaIR9qYgFxqwkQXZDduw7q3eLvKul97cirs3MAyDmTb039PX+V7Y+zzWj" +
                                                              "At0F9iNeNR5nAG7Fo5Z1QmIfwS8A13/xQklhh4ghDR12IJubiWSGkQbMFxdJ" +
                                                              "PbMJCO1oeHPbXe8+IAjwR3rfZLprz1c/ar1pjxC3SIcW5GQkXhiREglysGlD" +
                                                              "7OYV24VDdL1zaMdj9+64QWDVkB3cOyF3feAX/3m+9fa3ns0TPyZYCd0USe05" +
                                                              "aAEZfz8lWzqCpNU31j6+u6GkC1xNN6lIacqVKdod9a4J+ZyVinjE5SZavMNL" +
                                                              "HIoGQtESlIKtdI1cXRW9ddUIo1xhuzUjxSADpFKSwy7nU8/IYEw4xoSPhbFZ" +
                                                              "aHndcrZEPXn9oLz75fdr+t9/8gTnSnZh4PVCPZIhRFKPzSIUyXR/2FwrWQmY" +
                                                              "d86RdZfXqUdOwooDsKIM6YG13oQQns7yWfbsCeW/+tFT07a8WEKCXaRS1aVo" +
                                                              "l8TdP5kIfpeCYNRo2vjchcLtDFdAU8dJJTnE53Sg6c/J71Q6kwbjbmD7D6Z/" +
                                                              "7/wD+97g/s8WwWwOj1VoY1a85+WlG3Luf+mzPz9w895hoXFF7McHN+PD9Wpk" +
                                                              "56//lcNyHmHzmJQPfiB08K5ZHRe8x+HdUIfQLencJArSBRf2rPuT/wjOL/tp" +
                                                              "kJQPkDrZLuf6JTWFAWQAShjLqfGg5Msazy5HRO7dlgnljX6b9mzrD7JeQyll" +
                                                              "WUbhxtVqJ8w02SGnyR9XA4Q/bOYgp/F2CTanO2Gs3DAVKPmpL45VFVkUynLI" +
                                                              "33uZtT6GZSZkt1b2YUTGSXO7FA7h8qqjP7S+9fuHhSLkCwG+8ufeAxXya8mj" +
                                                              "PATgtisyCE5CfOrhshVe3BnZdIrpOBbl0jALxamehAKQJSBbjLOEk+2P5/Lo" +
                                                              "KxYWNg4PH/d9e8ELV+9b8Db3HBWKBSoE4S1PCeqBef/gm+8dq2l6kOd9pRgl" +
                                                              "bZebXbvnluZZFTeXQi02CaEs59qRB28rPc/tjJQoWk6owL9r0jkBBP9fKla1" +
                                                              "lZXlV9YgPrZCIIopmqRybNogDVM5F/EfrxSThrtFUMA5IUNkOGiZUJ/rGuXp" +
                                                              "iD02xQknmbMRGMxF1iRNWd6uh/PHdR2vT7rlN4db4qvGUthgX/MopQv+nwNC" +
                                                              "XlJYR/yoPL3zj7M2XpDYMoYaZY5PhfxL3tdz8Nk1i+Rbgvz4Rfi0nGObbKC2" +
                                                              "bE9WaVKWMrXsIL9ASJ9LT4gem6VcwEVi+FeKjO3C5jrQFRkFLfSiyPSv5YZF" +
                                                              "7Og3PBE0S4tFuYJtDzaDQlN6C4bgS7Nd9ky4mm3n1VzAZe92WSHl+uZC0MyO" +
                                                              "IhyCZuAacdpcQP9xASbujMin6NMiphKN09AqUOc+fl6gaPFObUgxdS2JhmK7" +
                                                              "zk9jGyECbmF7R/VPpRHIGsfqoPY6ovlmMQeFzbDwTtikM57pjlzPhH+3Y/PF" +
                                                              "/NteLbbl0Nh8uYgOHygydh8292Bzo8CkyNzvnKIt3DxGW5gH1xxbm+cUsIWH" +
                                                              "itpCIWhGqtMdum5GIV6AtH0mwbOIyXC12OAtwiSUU9RVAEuGhjAZxLcDSlLi" +
                                                              "BbCI9ZhM8zzRMYxPbzOPeTzKRXZeYUV/1OH7Y59I0Q9/QkUXeB0eTdF/XGTs" +
                                                              "J9gcySj64WKKfvQUFf27n0DR59q6NreAoj9XVNELQYOij3gUHfse8SH7/BiR" +
                                                              "nWYj7CCeD9ljRZEtBI1BWU9p/ERL82H5UhEs057UILMb/5UR31sAz26eWpVg" +
                                                              "kt1U6EUNPx/Zv3PPvuj6e850ao5VDCps3ThdpUNU9Sw1UShtBo1ah9AVNhor" +
                                                              "/CxzCfVRkDk1LATq02CPRmp81d8VUfF3sHkLitI4ZZ1YsrkVG1/A5fzbo+lH" +
                                                              "8UMEYTg+rnDwGXCttElbOXauFAIdjSt/LcKVv2NznJEK4EqXU3Lf6fLiz+PA" +
                                                              "CyxXeYBqtwlqHzsvCoGOxouPCvMiwKd9yMgk4MWlrg/B3vNcjpwcT4502mR1" +
                                                              "jp0jhUBH4UigughHJmFTLjhyWSGOBCrGgSOYjPCEvtsmq3vsHCkEWoTgmUXG" +
                                                              "ZmMzhZEqPPJK8vcrdLTcujyi6yqVtCLpNWfh1HFgIXfEWOz02HzoGTsLC4EW" +
                                                              "YdPSImOnY7OIkRrQp15dwTeiTvRzeXHaePEC1elim6CLx86LQqBF6D23yNh5" +
                                                              "2JzNSC3wwg5E+bhxzjhwg2c16Dm32CRtGYUbeVKaQqA+ij05L09wujntnUX4" +
                                                              "sgabCxkej0hR7nOsfJZVOqQrUZdN7ePFptVwXW/Tev3Y2VQI9GOx6ZIibPoC" +
                                                              "Nr2QkyGbnMgd6HY5cvH/gyNpyJdyP4TA9yQzcr7FEt8PyQ/uq62Yvu+SV8QB" +
                                                              "q/ONT3WYVMRSquo9yfc8lxkmjSmcn9XiXN/gVA4yMn/0N6qQRjPnADOwWUBG" +
                                                              "GGksBgkahDcvCKwzvQAII2XiwTs/wUidfz6gwu/eedBZ6c6DpcSDdwpsUAJT" +
                                                              "8FEXajiDkdDHfJfsiCUdyM7wHVUgo0YXT1GwIOtUlX+X55yApsSXeYPyoX0X" +
                                                              "rbvqxGfuEd8gyKq0ndezVWFSLj6H4IviKeq8gqs5a5WtXXxy0kMTFzplRr1A" +
                                                              "2LWs2a7Sk34InQZq3yzfC3qrJfOe/tX95z/5s11lx4IksIkEJEYmb8p9DZU2" +
                                                              "UlD/bArnvq7tl0z+5UDb4jtHLlgW+8tr/EUfEQfejYXnD8ovH7jipVtm7G8O" +
                                                              "kqpuMgEqKJrm78dWj2gbqDxkDpAaxepMA4qwiiKpWe+CJ6GhSPjFHueLzc6a" +
                                                              "TC9+wQK2kPsiPPe7n0pVH6bmKoglUVymJkyq3B4hGd9BdMowfABujy1KbLuE" +
                                                              "B0ZpgLoOhnsMw/lOoGqdwT3GmvyJDur1Tv6IT9f9D7FtzEOzKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "m3G16qQN0o5Juz/qr12pE6A9gatxTg+W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("sMjbhu3EQfJKk+tJDSsZUo6+rHSSCO5zWp/RVGu98nodfztsW2bAJ2570JnZ" +
       "YbCZ6P1wPIrcdkdZWjVdCnup3QswMVWDCdYId6Y5DpZqBR+1BgZLW8Rwo1K5" +
       "3BIXOFrZMeOaTccmTavA3wT8sCW5Y193OD5zR3YW1rsNY6CgXWXi7zSsC+he" +
       "HUvUpt9FhECn/JnhxZMd7Mz8QQj4XB+422zU20TVxbZFLlAN7bWJJO/PcrBq" +
       "xoptqH/5xrbH7it3Ao+Og1pOu8j46hvYAUtPvKE72jEtPxehU0cIT+yYnjjo" +
       "ABVHMR651SnP8mDKFz7+4svK7Beq5w/2mdEEupz4wY866lZ1TjR1eb/zfSTG" +
       "lcPNWvRADPT0xu0x0Jvv2v7IXlGn9rzPHRdYlwW+fsam+B8Vyb9PoPt1NekX" +
       "hwWOzwqUDRyr+T+81kbjyaZPQS2LPQiuDxxA/cAPCOqfnAH1vxXJHyfQJQCV" +
       "ODyc8dFjgN94EwBLWhUvq7ADgNgPCOCfnQHwz4vkfyTQvQDg6vgFQ/G0eQzz" +
       "f74VMPsHMPs/GJjnbrs1zHMXi4ff28Nc3wrmOehNwHxb8bB4L04ewCTfGpgn" +
       "UVw9I+/+Irkrge4qzia55YFM9WbvA+6QfN9RRe8Y9d1vAnXpj4p395MD1JO3" +
       "HvVjZ+QVXvrcQwl0DxhX2je9BD96FXUM8F1vFmAxrMwBQOatB1g5I+9Hi+Td" +
       "CXQFADxwsjeD+MNvAmL5MrDwPc8fQHz+jUJkbgrxxGvd8r3g+0tA7TPAokVS" +
       "S4ozNKJSWml801daW99UjrHX3yz2Hrg+cYD9Ez9I7MQZ2ItXbucwEAYU2A+n" +
       "mnPPHsPsvhGYKZidbzygX5w2fvCG/wjt/9cif+nlK5fe+TL3r/cn8Q7/e3KZ" +
       "gi5pG8c5eRjxxP3FIFI1s1TB5f3RxKBEM0ugJ1/7cHIC3Z4cHhI7N93XnCfQ" +
       "w2fVBMNffJ2swiXQO29RpXhbXN6cLL9KoKunywNRyu+T5X4CMPG4HGhqf3Oy" +
       "yIcS6AIoUtw+tz9H8I4Egl/nsezDYUnPXR88Hg45dP9rDfmJePOp687Nlf8X" +
       "Ozzjttn/Y+w5+csvj6Yf/k7rF/bH+WVHzPOilUsUdMf+nwVlo8U5uSdu2dph" +
       "WxeH7/nuvV+5/MxhBHvvXuBjczkh22M3Pzvfd4OkPO2e/+N3/qP3/72X/7B8" +
       "Nf7/ARmUrQjINwAA");
}
