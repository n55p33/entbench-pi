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
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
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
                                                              "B0ZpgLoOhnsMw/lOoGqZwT3GmvyJDur1Tv6IT9f9D8zwOkuzKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mcPNqFq10wZpRaTVH/XXjtTx0Z7A1Ti7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("B0tY6O6CdmwjeaXJ9aTGJh5Str6sdOIQ7nNan9HUzXrl9jrebtjemD4fO+1B" +
       "Z2YF/nai94PxKHTaHWW5qelS0Eutno+JqepPsEaQmObYX6oVfNQaGCy9IYZb" +
       "lcrllrjA0UrCjGsWHZk0rYJ44/PDluSMPd3m+MwZWVlQ7zaMgYJ2lYmXaFgX" +
       "mHt1LFHbfhcRfJ3yZoYbTRLYnnmDQEgW9YGzy0a9bVhd7FrkAtXQXidPZtY2" +
       "B6tmrNiG+levb3vs/nIn8Pg46MZuFxVfeR07YOmpN3THO6bl5w7ozBHCUzum" +
       "pw46QMVRjEdvdcqzPJjy+Y+98JIy+8XqhcN9ZjSGLsee/8O2ulPtU11d3u98" +
       "H7Nx5WizFj1kAz27cXsC9Oa7tj+0F9SZPe+DE4J1SfC1czbF/7go/kMMPaCr" +
       "cb84LHByVqDs4ETM//HVNhpPd30Gakn2ELjefwj1/d8nqH96DtT/XhR/EkOX" +
       "AFTi6HDGR08Afv0NACzNqnhZhR0CxL5PAP/8HIB/URT/I4buAwBXJy8YiqfN" +
       "E5j/882A2T+E2f/+wDy47dYwD+4oHn53D3N9K5gH0BuA+ZbiYfFenDyESb45" +
       "ME+juHpO3QNFcXcM3V2cTXLKA5nqzd4H3Cl5nq2K7gnqe94A6jIeFe/uJ4eo" +
       "J28+6sfPqSui9MHDMXQv0CvtmW6MH7+KOgH4jjcKsFArcwiQefMBVs6p++Gi" +
       "eFcMXQEAD4PszSD+4BuAWL4MLGLP84cQn3+9EJmbQjz1Wrd8L/i+ElD7HLBo" +
       "UdTi4gyNqJReGt30ldbOM5UT7PU3ir0Hro8fYv/49xM7cQ724pXbAQbSgAL7" +
       "0VRz8OwJzO7rgZmC2fnGA/rFaeOHbviP0P5/LfIXX7py6e0vcf9mfxLv6L8n" +
       "lynokra17dOHEU/d3+GHqmaWIri8P5rol2hmMfTUqx9OjqHb46NDYgfTfct5" +
       "DD1yXkug/uLrdBMuht5+iybF2+Ly5jT9KoaunqUHrJTfp+l+DFjiCR3oan9z" +
       "muSDMXQRkBS3z+3PEbwthuDXeCz7SC3pwfXJ45HKoQdeTeWn8s2nrzs3V/5f" +
       "7OiM23b/j7Hn5C+9NJp+6NutX9wf55dtMc+LXi5R0J37fxaUnRbn5J68ZW9H" +
       "fd0xfPd37vvy5XceZbD37Rk+cZdTvD1+87PzfcePy9Pu+T95+z9+399/6Y/K" +
       "V+P/H160pT7INwAA");
}
