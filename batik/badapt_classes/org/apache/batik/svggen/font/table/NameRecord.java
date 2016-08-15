package org.apache.batik.svggen.font.table;
public class NameRecord {
    private short platformId;
    private short encodingId;
    private short languageId;
    private short nameId;
    private short stringLength;
    private short stringOffset;
    private java.lang.String record;
    protected NameRecord(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        platformId =
          raf.
            readShort(
              );
        encodingId =
          raf.
            readShort(
              );
        languageId =
          raf.
            readShort(
              );
        nameId =
          raf.
            readShort(
              );
        stringLength =
          raf.
            readShort(
              );
        stringOffset =
          raf.
            readShort(
              );
    }
    public short getEncodingId() { return encodingId; }
    public short getLanguageId() { return languageId; }
    public short getNameId() { return nameId; }
    public short getPlatformId() { return platformId; }
    public java.lang.String getRecordString() { return record; }
    protected void loadString(java.io.RandomAccessFile raf, int stringStorageOffset)
          throws java.io.IOException { java.lang.StringBuffer sb =
                                         new java.lang.StringBuffer(
                                         );
                                       raf.seek(stringStorageOffset +
                                                  stringOffset);
                                       if (platformId == org.apache.batik.svggen.font.table.Table.
                                                           platformAppleUnicode) {
                                           for (int i =
                                                  0;
                                                i <
                                                  stringLength /
                                                  2;
                                                i++) {
                                               sb.
                                                 append(
                                                   raf.
                                                     readChar(
                                                       ));
                                           }
                                       }
                                       else
                                           if (platformId ==
                                                 org.apache.batik.svggen.font.table.Table.
                                                   platformMacintosh) {
                                               for (int i =
                                                      0;
                                                    i <
                                                      stringLength;
                                                    i++) {
                                                   sb.
                                                     append(
                                                       (char)
                                                         raf.
                                                         readByte(
                                                           ));
                                               }
                                           }
                                           else
                                               if (platformId ==
                                                     org.apache.batik.svggen.font.table.Table.
                                                       platformISO) {
                                                   for (int i =
                                                          0;
                                                        i <
                                                          stringLength;
                                                        i++) {
                                                       sb.
                                                         append(
                                                           (char)
                                                             raf.
                                                             readByte(
                                                               ));
                                                   }
                                               }
                                               else
                                                   if (platformId ==
                                                         org.apache.batik.svggen.font.table.Table.
                                                           platformMicrosoft) {
                                                       char c;
                                                       for (int i =
                                                              0;
                                                            i <
                                                              stringLength /
                                                              2;
                                                            i++) {
                                                           c =
                                                             raf.
                                                               readChar(
                                                                 );
                                                           sb.
                                                             append(
                                                               c);
                                                       }
                                                   }
                                       record =
                                         sb.
                                           toString(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16a6zj1nkg59oz9kxtz9hpYtf125PsJmwvRepFYtokFEVR" +
       "Eh+iREqU2IdD8SFRfIoPiVLrNgmQJmiANNh12hRo/SvtbgM3CRZNd7G7Xbi7" +
       "2DZFH0CLoC+gSVB0d7ttgzY/+tp0N3tI3Xt17525YzsxKoBHh+ec7zvf+3w8" +
       "57zyVehyHEFwGLibmRskh2aWHC7c6mGyCc34sMtVRS2KTYNytTiWQdsL+nOf" +
       "u/53X//4/MYBdEWF3qL5fpBoiR348cCMA3dlGhx0fd9Ku6YXJ9ANbqGtNCRN" +
       "bBfh7Di5xUHfdgo0gW5yxyQggAQEkIAUJCDkfhQAetD0U4/KITQ/iZfQj0CX" +
       "OOhKqOfkJdCzZ5GEWqR5R2jEggOA4f78fQSYKoCzCHrmhPcdz7cx/AkYeemn" +
       "fvDGv7sHuq5C121fysnRAREJmESFHvBMb2pGMWkYpqFCD/umaUhmZGuuvS3o" +
       "VqFHYnvma0kamSdCyhvT0IyKOfeSe0DPeYtSPQmiE/Ys23SN47fLlqvNAK9v" +
       "2/O647CVtwMGr9mAsMjSdPMY5F7H9o0Eevo8xAmPN1kwAIDe55nJPDiZ6l5f" +
       "Aw3QIzvduZo/Q6Qksv0ZGHo5SMEsCfT4hUhzWYea7mgz84UEeuz8OHHXBUZd" +
       "LQSRgyTQW88PKzABLT1+Tkun9PNV4Xs+9kN+2z8oaDZM3c3pvx8APXUOaGBa" +
       "ZmT6urkDfOBd3E9qb/uVjxxAEBj81nODd2P+/Q9/7b3f9dSrX9iN+c47jOlN" +
       "F6aevKB/avrQ7z5BvZO4Jyfj/jCI7Vz5ZzgvzF886rmVhcDz3naCMe88PO58" +
       "dfBrk/d/2vzLA+haB7qiB27qATt6WA+80HbNiDF9M9IS0+hAV03foIr+DnQf" +
       "qHO2b+5ae5YVm0kHutctmq4ExTsQkQVQ5CK6D9Rt3wqO66GWzIt6FkIQdB94" +
       "oAfA8wS0+xX/CfQ+ZB54JqLpmm/7ASJGQc5/jJh+MgWynSNTYPUOEgdpBEwQ" +
       "CaIZogE7mJvHHavZzPQRC8gGSbSpayICMLOBqQeRcZhbWvjPMEeW83ljfekS" +
       "UMET5wOAC3ynHbiGGb2gv5Q26K995oXfPDhxiCMJJdB3g2kPd9MeFtMe7qY9" +
       "zKc9LKY93E8LXbpUzPbt+fQ7ZQNVOcDpQTh84J3SD3Tf95Hn7gFWFq7vBXLO" +
       "hyIXR2VqHyY6RTDUga1Cr35y/YHRj5YOoIOz4TUnGTRdy8HFPCieBL+b593q" +
       "Tnivf/jP/+6zP/lisHewM/H6yO9vh8z99rnzwo0C3TRAJNyjf9cz2udf+JUX" +
       "bx5A94JgAAJgogGDBbHlqfNznPHfW8exMOflMmDYCiJPc/Ou4wB2LZlHwXrf" +
       "Umj9oaL+MJDxQ7lBPwaedxxZePGf974lzMtv31lJrrRzXBSx9nul8Gf/8Hf+" +
       "d7kQ93FYvn5qoZPM5NapUJAju144/cN7G5Aj0wTj/uST4r/+xFc//H2FAYAR" +
       "z99pwpt5SYEQAFQIxPyhLyz/6Mtf+tQXD/ZGk0BXwyhIgK+YRnbCZ94FPXgX" +
       "PsGE79iTBKKJCzDkhnNz6HuBYVt2bsy5of7T9bejn/+rj93YmYILWo4t6bte" +
       "G8G+/Tsa0Pt/8wf//qkCzSU9X832YtsP24XIt+wxk1GkbXI6sg/83pM//eva" +
       "z4JgCwJcbG/NImZdOvKdnKi3gtBbQNrB4UDzjcAjdRAs4haIfoVikWLYu4ry" +
       "8HbgtxwDd3p0ppthTlABV86Lp+PTznPWP0+lLC/oH//i3zw4+pv/8rWC1bM5" +
       "z2lb4bXw1s488+KZDKB/9HykaGvxHIyrvCp8/w331a8DjCrAWDDVi0C0ys5Y" +
       "1tHoy/f98a/+t7e973fvgQ5a0DU30IyWVjgpdBV4hxnPQaDLwve8d2cZ6/tB" +
       "cSOvZdCJYKBCMFC2s6jHirdrgMB3XhyfWnnKsnfxx/5Pz51+8E//4TYhFJHp" +
       "Div1OXgVeeVnHqfe/ZcF/D5E5NBPZbdHcJDe7WGxT3t/e/Dclf9+AN2nQjf0" +
       "o9xxpLlp7ngqyJfi44QS5Jdn+s/mPruF/tZJCHzifHg6Ne354LRfOUA9H53X" +
       "r52LR/liCz0JnqeO/PSp8/HoElRUqALk2aK8mRf/4tj97wsjewUSgyPn/wb4" +
       "XQLP/8ufHFnesFvGH6GOcolnTpKJECxq10JXS/JI2jHurmExsj0Q1lZHuRTy" +
       "4iNfdn7mz39xlyedV+e5weZHXvrxbxx+7KWDU9np87cliKdhdhlqIa8H86Kd" +
       "O8izd5ulgGj9r8+++J/+7Ysf3lH1yNlciwafEr/4+//3tw4/+ZXfuMPyfhm4" +
       "RpTsVoC8rOVFcydY4kJ/efft2nz6SJtPX6DN4QXazKtMwXIb6AUseyCQ+rOO" +
       "kbcI5+gafRN0PXNE1zMX0PX9r4uu3DVSkMjfma4feIN0fQd4nj2i69kL6NJf" +
       "D11Xcl3emSbjDdKU6+25I5qeu4Cmxeuh6YG4+HriTH+2S7TPU+Z8E5Q9f0TZ" +
       "8xdQtnwDlO2+GO5EWfQGKXscPDePKLt5AWXZ69JjVGTPx4vyjWJ9y23ucPcp" +
       "eo7OzWvSuYsel0CsvIwd1g9L+fsH7kzJPWD6MJ26NkhQrsTFVz+Asmxfc4/J" +
       "e3Th6jePI+nIjGKwqN1cuPW8+8VztLVfN20gtj20Z5QLwBf3R//s47/1E89/" +
       "GcSpLnR5lS9OIKCdkoaQ5psQP/bKJ578tpe+8tEiJQSiHL3/7X9dWNpHL+Aw" +
       "r34oL34sLz58zNbjOVtS8XXFaXHCFymcaeScFSjYU/z0EpAIBrdp4vVzm1x/" +
       "pV2JO+Txj0PV5iQbogMF5pEVF8crGKfimNqsuUZIqvSYsN3Kcl2PIwlTxs1O" +
       "LLlxlFV1zMLW6qrsp4iBDdC+Eo2SoKm5rs1JDcebTjiKaWN8CZm2tAXjDzQa" +
       "HUbsiJkyZRlzQ0ka8WhoKKYOE3W8XPXKIYmGag/vYUgqmpau4xWC2K788sLF" +
       "fHegdj1vwQRp1u5r6CQpaUy1wds1rTbivY3gNK1YzPpzSxI5E0HL2cxFh4JT" +
       "CuYOoXvSYBwPl0st7sjdaUlae5rMorDtCh3dJCUJXS6ckC9Nh3PeVTIz6jHL" +
       "eMbWCEFukQ4meRol0CnvDYNNhtkrbkINsL7f7/IV1NZwtumDCTgsZraJjs8d" +
       "E7frItXqeuWpEw/CQMJqgwGrVhf2PBTZxjTadhPH1piot2WXW69T2mLcFO0l" +
       "cauWCeOW5cxW0zazhXGYb3TostVQaV82+KkQE6osoSAplcIGk5TNaTjyInnV" +
       "dUvz1szZluimKDlj0lvoPUdXF8PY0FwyLU2X3SlnpL7e7qmd5UJ1Rh17YI4r" +
       "87k3YJXRiicFXe0K/Q1WnvaawrTHjWZRRK03uE67uFUSp4pbC4JOqRm2mMEg" +
       "oQ1l0J/FtNOHG33PQaUSuhxJSXtIM74y4ej2UnM7y4iTx6mjSLgb0PGqgS+S" +
       "dK3X9P6wBIdwHCm0ud7q267c1LnqclTtCx6yTNilS7amYd3DqFlSjxs4H7UE" +
       "kpf5pG9sVa47nrakcmvTXc8GeJtZ2DhJTpuKSjnTUj+RR0ogGV1SoSV2GTJj" +
       "e5Y1asoM8Fzud/rd3sDTWlTJMJkuA495vz/pbLuksKGYGRNQxlra8M0OKvET" +
       "dy1FQpPdSGq53CNqyMSsmtggSCWqZ4PIyLKwg9NhNCFL5aUW2lrLkshJLdP9" +
       "prOQ/cSRu32pE661TkPHxHpUXePoKAnRSl/gBLbEZtx0yW+YqiZ2KZPAkiVa" +
       "4yfsiBWVElVqtQjC7xmESyJqRyUq5LzrKk7HbvKKtUbF0Cr7dXGCyATL+lHX" +
       "UDZRqm1o2hLisIK2uoqWoKzgzdnFclTZzJRlyC3qpoRFM1FrBSNRSqWanmz8" +
       "sBvqy/rSH8MMuhk25u0gWISVUV0q1aP1lJ6v5vWy16RbnWaz5rXDqtJpIoSn" +
       "Mgk+4BEppQact+RCvN+SB+Bjqkc1erS/rtMOQaEMLCrlqDdvUHwNm3icQ+uL" +
       "VsOfNCU5GAV4JAmUNPRG2SqebwVVVmRD5ifrUgXB14OsnvjNtWLrpJSQk0a/" +
       "oxBxSR0Pib7urix/5BtWr9nGndksLTcobJ7NVSoRmYzrZ6KH8nJj1dQUAcfC" +
       "WZ2buDTMZLLeXmYY1xhiWFsm4UjhsiU+gcuKaJZGNDNmFGpcYYb+1DI8f1Ma" +
       "Mg281q6qfNKUV74/WmFWdzDsOjbX5Xp6yHQ2ijLySHbq1C21FwF+xz4nr9FM" +
       "NGMKV9NgI/fp2lwbdpXSMhGdUKgzhmM7JuXUs7WHT5vDktFFdC+cYWJ5utpu" +
       "0BEtEYpO+1yHXZNbtZE121R5YdBDiRr6nalRR8oV3Wmm5f6YLq/DLPb4gZoF" +
       "/XK8bgdcyqiT8baqmIxf9UZrowyvZXJKTRvtGV+ZkqteZdLT5ZkJl1RV45t2" +
       "4qFuN5Pa7aw8ijNBbpcbFXPJl3Grv6QzSdZnW3GmKPOVtKoJAcHzU9bk1vyk" +
       "QqGLRgkX/UYFa1uIyI6r6tbYpmootGRylklo6ja4TFbWPrPE+uVpU9LcvgjW" +
       "h0l7JbbnMIFNzLhEZitCotvGHCOVqEEH7HSFTClfsaze2HJkQRL00sRj2GkP" +
       "gMkjrjrrrmuD+aKLrYM+N1aHJNlS+rNOW9bVmOloS6dlZEjKWXB5Op9hIwHB" +
       "iNjpO0yrbZtSFC1LJGchdjJ2/NDELEFmsuHAkXkqxdD1ZmYu5bEOQmhL1Gbj" +
       "yKmX0YTwDVFaE01r1uCTUDJcXgByqqdLoc9vGpo+JFqL2maYhIox3kwaq9EM" +
       "JwUXmdS2CxWdbogknFfjWNTTWqXOoXyzZXZxAWO3a7GbtlcITLQG6hrpNNVt" +
       "NcDERSPOzMrSqmy2gziyVG7A6h3Zq4yqdBMnKKYadZmYrrEVArWQVnc1Hg5U" +
       "stJosNWhmYC4beNcvRvXwMJW3tbLCAcyNFTrayQcDsvDEJXETB4G3rpXm6Gz" +
       "+UwnqhNz2ussuJamdaM1N8TZhd3WeWlgoR0m4mtWKfUNv6mrYy01xXALVyvp" +
       "Yq5vM7YptRat1Fytx/K8j43MOrcicWERCfUsI4S4nTlSNaZmerMv4DxSQ2Wn" +
       "bBJwvT2Q6n6vZdsu6a+buCK21Ug1DLHuC3ir25PTTcP0e2QDdRFTy+ocsuDU" +
       "MbLpslqgdhxsPUaz2BUm1tQiZ6wUp2HK0iRRKdftkjCgxkOF5HSU6mimNhH6" +
       "NVZVTNpYWgzeCRqE0sH6mMiUMDbqt0oSQcF0bKl1T0oqaaaYS1KeoHPWJ8lg" +
       "zQTeaM6wlIDO7SDLepHpNvFkAgfTLTVMJLbFtuaNLcpWQNrjT9gUCRnRXlAd" +
       "PpIWZCddemIWwVVcRxOuzONRPHRWOp2V1R7VUd264zByCagCpuUZ3O9baGNW" +
       "H3TGSslTxvaY5wyJZXTDrTQbs36ZGG+2K7VZz0rjxkxqcqUGT8AbBCHESXlV" +
       "oib6aD4pVwcrE3Hpvt6b9CuYh1J10xx5lcGasLa1ag122wZcUpRoXJFgI+01" +
       "HBNBRsg4qBiIgHFdbYmyASk42XDe3QxYBA6ArOtVMxXFtmeHtQ5Nl0vJUq+G" +
       "G7VSx8JVNlc80XXCuqsHeDZNF1qWtiW+0VWbbDwrLXoYWwfZQZmp8HOZn9ql" +
       "HpLnbHylC8LrgGsZNo+SelVp63Rv1A+dpl3asgRrblWm1UCrzV7QS0xzytQ6" +
       "SzdUR3qv0h+NaS9b6+1SGi0DQkal1cxTDFGwCRodZcUYRvMZm/KSajqroHrf" +
       "1eq6r82IAQ7XNsB+Mh7trnCVJ1xxqOr9Gc9Gq4jfzOrlajW1Ansz3njRtDEv" +
       "90dutqYwt96y2ksz481mFNfkkHI5DIm47rzcIMnuAkF68kijNyAta1cXlUXH" +
       "DcSgvFnaZrOERuhwki6l5cYjxpWwGtByipuZnI2aw3bJH6DYWmcHBD4n4DXs" +
       "owts0+zSY2ZqkJheLU1qLjuo+Ut6pAiOv24N5zAy9NloMdX9urVqyttgs8SN" +
       "7SRW4MRJdclql9v8jLVxYTtuUaMSYhGGqTFeScMWqbjuSdYs1JqdNjIxTKSt" +
       "zC0WZjkcobFRvzTFpn7Nl310vJT5cAO+tsQOwnM1YsnXKkOQx2UmWp6txwJa" +
       "qURMrZzBkaGMJmRF50JMZsoVeMjIKbu1dFXT5300RcWOUp0gcEPq1bs4OqkY" +
       "5f50JaJybMMK1tdX7XolXqMLDhPdllen3XgxS6yuuK5uVuOWra9cqiJlDBDJ" +
       "dG4jHN6dbIhFHd92F1usvR2uSRanFcRbDwxxmxE9pQdsR/N0JIMphgc+uuJU" +
       "XTXXplayO15j7dB2pROPuYBfKT7Js1V2lDh0lMEwxwsAdVhJeGSiCJ4+0foD" +
       "y24nA2HtAg8bM0zVajDIdsmRLdHFUAndKHisyRXBXvKC0shcKpYyFRnjeEXA" +
       "mLXkJfXUnMJNpx+22C3IuGi8ukXG1SFI5OZwdwsCGy5EhA8Mgu5x4lDoKos0" +
       "7G7a1jZFcK5hqovRymwyXnWoDizYtS0CqTZ6bQZL/Xa9nshqHaUQZIDSIiyn" +
       "xhAdrzCino2ZjSqwxJY1fVru8FWxvRUlK/XqxnaxwRU4RYYmhW86i8gcVtZD" +
       "pFJVxtV5tx12pKxvBM64WS7RdsR4nSYWrCOYMLrjmdjVe4OOM+ZKjjAgzX6F" +
       "SZOh1oVbop7AExtxqTTGjQEXTRkfDlerZTWqtGtGb67yslUt9TYbXYxgDKnh" +
       "HAqcg5ug3shIqzQ7EOddapvG/WRUirK+NqnFtYXCcU61ZvEdKqxW49ZsWe+V" +
       "KaWxlWodkwS5N6zOlGS0rAnrtBxhm07oW3XFhxfDCqzgHj3xBhs15aa16WYw" +
       "q7MlHOtW5jwy6sr4KjK2JcvAyu3BCE6JFT6NkY5X6SixGM7h4XYAExXLgPkO" +
       "hg74iBmDJDCURRHfpBulPYhiG21t7WY/GPm6OSL7ob2Ua9Gc9yrDWl/nic2K" +
       "WKRTalGquLhI97YtY+O3LGJBInN4UfUCIkTaw9KMHEXGajHiU7i/EHyGpEHm" +
       "bJiSt5FJZ74WJNKcZwIxT1u6MCzrapsMHDpuMuQ05cQaO62VkcZkqdTKxLDT" +
       "J8n8s/2n3th2wsPFLsnJbYNvYn/kbntFH9qfdBW/K9C5M+tTe0+nTjCgfAv5" +
       "yYuuFRTbx5/64EsvG72fQ/PtlBxQTKCrSRB+t2uuTPcUqisA07su3irni1sV" +
       "+xOJX//gXzwuv3v+vjdwTvv0OTrPo/wF/pXfYN6h/6sD6J6T84nb7nucBbp1" +
       "9lTiWmQmaeTLZ84mnjyRbCHd/DwCOZIscn5Xb6/Ni9RUKPncodvx2VL+/pm7" +
       "9H0uL34hgR6cmQl9dit8b0Gffq09p9NYi4afv53B8hGD5Tefwf94l77/nBef" +
       "3zHInd1T3zP4y98qg/m+bP2Iwfqbz+Cv3aXvC3nxq8CDAIPCfnN+z9x/fTO0" +
       "d+uIuVtvPnO/d5e+L+bFb++0J56coJ1j8He+BQYfyRvzE5H3HDH4njefwS/d" +
       "pe8refFHCXQdMLi70LLff39xz+IffwssFtcxOPBQRyxSb5TFf3lHFg+KAQf5" +
       "a+lOu9f32H5SAP7FOcBLe8yVYsBf58X/SHbH6Dv+77gdvgpsYy+T//lGZJIB" +
       "7PtLQ/n1h8duu5+4u1Onf+bl6/c/+vLwD4p7Myf33q5y0P1W6rqnD5xP1a+E" +
       "kWnZBTdXd8fPYfH3jwn03GvfZ0qgy8V/QfY/7CD/KYGeuBskkEf+dxrkGwn0" +
       "6AUg+UlLUTk1/tJBAt04Px6QUvyfHncZCG8/DqDaVU4PuR/oGwzJq1fDO5wq" +
       "7Q75s0tnE4UTXT7yWro8lVs8fyYjKC6jHq/e6e466gv6Z1/uCj/0tdrP7e4Q" +
       "6a623eZY7ueg+3bXmU4ygGcvxHaM60r7nV9/6HNX336crTy0I3jvNKdoe/rO" +
       "t3VoL0yK+zXb//DoL33Pv3n5S8VB0v8HOoWH2iUsAAA=");
}
