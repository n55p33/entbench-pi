package org.apache.batik.svggen.font.table;
public class CmapIndexEntry {
    private int platformId;
    private int encodingId;
    private int offset;
    protected CmapIndexEntry(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        platformId =
          raf.
            readUnsignedShort(
              );
        encodingId =
          raf.
            readUnsignedShort(
              );
        offset =
          raf.
            readInt(
              );
    }
    public int getEncodingId() { return encodingId; }
    public int getOffset() { return offset; }
    public int getPlatformId() { return platformId; }
    public java.lang.String toString() { java.lang.String platform;
                                         java.lang.String encoding =
                                           "";
                                         switch (platformId) { case 1:
                                                                   platform =
                                                                     " (Macintosh)";
                                                                   break;
                                                               case 3:
                                                                   platform =
                                                                     " (Windows)";
                                                                   break;
                                                               default:
                                                                   platform =
                                                                     "";
                                         }
                                         if (platformId == 3) { switch (encodingId) {
                                                                    case 0:
                                                                        encoding =
                                                                          " (Symbol)";
                                                                        break;
                                                                    case 1:
                                                                        encoding =
                                                                          " (Unicode)";
                                                                        break;
                                                                    case 2:
                                                                        encoding =
                                                                          " (ShiftJIS)";
                                                                        break;
                                                                    case 3:
                                                                        encoding =
                                                                          " (Big5)";
                                                                        break;
                                                                    case 4:
                                                                        encoding =
                                                                          " (PRC)";
                                                                        break;
                                                                    case 5:
                                                                        encoding =
                                                                          " (Wansung)";
                                                                        break;
                                                                    case 6:
                                                                        encoding =
                                                                          " (Johab)";
                                                                        break;
                                                                    default:
                                                                        encoding =
                                                                          "";
                                                                }
                                         }
                                         return new java.lang.StringBuffer(
                                           ).
                                           append(
                                             "platform id: ").
                                           append(
                                             platformId).
                                           append(
                                             platform).
                                           append(
                                             ", encoding id: ").
                                           append(
                                             encodingId).
                                           append(
                                             encoding).
                                           append(
                                             ", offset: ").
                                           append(
                                             offset).
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
      ("H4sIAAAAAAAAAL1ae+zrVn33vbf3Sdt720LbldLnhdGm+zmJ81SBkcRxbMeO" +
       "nTh2Eg+4+JXY8TN+JLZZt4K0gUDrECsMJqj2B+yBymNobEgTrNvEAIGYmNBe" +
       "0gBNk8bG0OgfY9PYxo6d3/s+SgVaJJ+cnPP9fs/3dT7n+Jw8+13odOBDBc+1" +
       "koXlhjtaHO4srepOmHhasENSVVbyA03tWFIQjEHbFeWhT178/g/erV86CZ0R" +
       "oTskx3FDKTRcJxhpgWutNZWCLh60di3NDkLoErWU1hIchYYFU0YQPk5BLznE" +
       "GkKXqT0VYKACDFSAcxXg1gEVYLpFcyK7k3FIThisoF+ATlDQGU/J1AuhB48K" +
       "8SRfsnfFsLkFQMK57LcAjMqZYx96YN/2rc1XGfzeAvz0r7/p0qdOQRdF6KLh" +
       "cJk6ClAiBIOI0M22ZsuaH7RUVVNF6DZH01RO8w3JMtJcbxG6PTAWjhRGvrbv" +
       "pKwx8jQ/H/PAczcrmW1+pISuv2/e3NAsde/X6bklLYCtdx7YurUQy9qBgRcM" +
       "oJg/lxRtj+Um03DUELr/OMe+jZf7gACwnrW1UHf3h7rJkUADdPs2dpbkLGAu" +
       "9A1nAUhPuxEYJYTuua7QzNeepJjSQrsSQncfp2O3XYDqfO6IjCWEXnacLJcE" +
       "onTPsSgdis93B6956i0O7pzMdVY1xcr0PweY7jvGNNLmmq85irZlvPlR6n3S" +
       "nZ99x0kIAsQvO0a8pfnDn3/+9Y/d99wXtzQvvwYNIy81JbyifFi+9Wv3dh5p" +
       "nsrUOOe5gZEF/4jlefqzuz2Pxx6YeXfuS8w6d/Y6nxv9+ezJj2rfOQldIKAz" +
       "imtFNsij2xTX9gxL83uao/lSqKkEdF5z1E7eT0BnQZ0yHG3byszngRYS0E1W" +
       "3nTGzX8DF82BiMxFZ0HdcObuXt2TQj2vxx4EQWfBA90Mnnuh7Sf/DiEV1l1b" +
       "gyVFcgzHhVnfzewPYM0JZeBbHZZB1ptw4EY+SEHY9RewBPJA1/Y61ouF5sBz" +
       "4Bs4lGRLgzu25BGOqsVdJ/STnSzbvP+nceLM3kubEydAKO49DgQWmEO4a6ma" +
       "f0V5Omp3n//4lS+f3J8Yu54KoRIYemc79E4+9M526J1s6J186J2jQ0MnTuQj" +
       "vjRTYRt4EDYTAACAxpsf4d5IvvkdD50CGedtbgI+z0jh6yN05wAyiBwYFZC3" +
       "0HPv37xV+MXiSejkUajN1AZNFzJ2NgPIfSC8fHyKXUvuxbd/+/ufeN8T7sFk" +
       "O4LduxhwNWc2hx867mDfVTQVoOKB+EcfkD595bNPXD4J3QSAAYBhKIHkBThz" +
       "3/Exjszlx/dwMbPlNDB47vq2ZGVde2B2IdR9d3PQkkf+1rx+G/DxrXsZ/tBu" +
       "tuffWe8dXla+dJspWdCOWZHj7ms570N/89V/RnJ370H0xUOLHqeFjx+ChUzY" +
       "xRwAbjvIgbGvaYDu79/P/tp7v/v2n8sTAFA8fK0BL2dlB8ABCCFw8y99cfW3" +
       "3/zGh79+8iBpQui857shmDOaGu/bmXVBt9zATjDgqw5UAshiAQlZ4lzmHdtV" +
       "jbmRJXSWqP998ZWlT//rU5e2qWCBlr1MeuyFBRy0/1QbevLLb/qP+3IxJ5Rs" +
       "ZTtw2wHZFi7vOJDc8n0pyfSI3/qXr/jAF6QPAeAFYBcYqZbj14nduZMp9TIA" +
       "wzmn4e6MJEd17ZYCQCPAABLmgYVzskfzcudq5jv2mAmmGyualymU8yFZcX9w" +
       "ePIcnZ+Hti9XlHd//Xu3CN/73PO5qUf3P4dzhZa8x7fpmRUPxED8XceRApcC" +
       "HdBVnhu84ZL13A+ARBFIzI1ifIBY8ZHM2qU+ffbv/uTP7nzz105BJzHoguVK" +
       "KiblkxQ6D2aHFugA7GLvZ1+/zYzNOVBcymoxtO8YKHcMFG8z6u781xmg4CPX" +
       "xycs274cTPG7/4ux5Lf9w39e5YQcma6xah/jF+FnP3hP53XfyfkPICLjvi++" +
       "GsXBVu+At/xR+99PPnTm8yehsyJ0SdndRwqSFWUTTwR7p2Bvcwn2mkf6j+6D" +
       "tov+4/sQeO9xeDo07HFwOlg9QD2jzuoXjuFRtvBCLwfPfbvz9L7jeHQCyiud" +
       "nOXBvLycFT+9N/3Per6xBpuE3cn/Q/A5AZ7/zZ5MWNawXdJv7+zuKx7Y31h4" +
       "YGG74FlSmCEpod44wqxv2ADW1rv7KviJ279pfvDbH9vumY6H8xix9o6n3/nD" +
       "naeePnlop/rwVZvFwzzb3Wrur1uyAs8myIM3GiXnwP7pE0/80e888fatVrcf" +
       "3Xd1wWvFx/7qf76y8/5vfekaS/wpsKfe4n9W1rIC3bq1ed3Z8rqrY3n/bizv" +
       "v04s+evEMqv2coNxEBWw6AEYdRaEmrUMjuklvEi97gLPA7t6PXAdvd7wo+i1" +
       "u7+8lk5vfEGdtnE8AbL2dHmnvlPMfivXHvUUGMqLZMsAS8WZIH8XA1xzw5Gs" +
       "PVXuWlrK5b2cFsC7GYCXy0urvgfnl3JkzCbyzvaF5pi++I+sL8i8Ww+EUS54" +
       "N3rXP777K7/68DdBFpHQ6XUGHSDdDo04iLLXxV9+9r2veMnT33pXvmADVwpP" +
       "vvLf8s23ex2rs2quZ05l7Jl6T2Yql++BKSkI6XyB1dR9a/uH7GFCsEy7P4a1" +
       "4a1P4pWAaO19qJKIzmJeiCcFBl5TsM826rjURiaCKPWxYtvw3KRDhBQVbBg6" +
       "jCZdfzmzHG1NmWmhgA60CozUo5ThV2a4nPUkgzB4d9HliE0xdPkOvQTAuxmh" +
       "8mwVkpP6aNJKhRVhrUhSEVejPuIg7Fpbk7DY40kDmYyjNeUgDs6yzFxT6tW0" +
       "3gw2A96uiR5RWlH0xkZ7K0xL+XKfNCfjOeeatgCWPXNUEC2uJsGybzcVMLqw" +
       "qY0KAkXVRMU25kNP6DZnG1sauJhHF23Blft8cRHX2iQ1WTEcn47CSTcZ1nuG" +
       "xA8EkZiWahu738YCky5KNucmIrdMUWkwnGxoQ+n1FlxF9LrCQptGZcYUQmnQ" +
       "EbVGzLNapWS1E5+rWw2BmJUTHHRgtBmPiBTHZmFJNJuxX2O8LhcKot0TRY3Q" +
       "aggut/VwmbBttejYcKUxkNtFXo4Wts15kU3bZTV0PSlahlh3iXKVoF5cjYWo" +
       "nvQYc9AVVyzN0So9UcYcs5GGw7IqxaUVj9aZlWcVl8XaoKJUTcOleyPBEPvV" +
       "udHpiXzoTuiGXmovLCGlJJWuMCV8bPm6KFTJZbUpF8YbuhlI61Kp33NFclEj" +
       "Bu7YTfo0tjDL2KbfRfDVxA7HxsideTpd0jobvWZ4XH+VlNO6R5ohKY0oasN2" +
       "63KAk8suNliv5n4/1fGARuiku0GUwszSeFRcN1bjlTfsTMpaLVy4VAFpaWg/" +
       "ngzRbtrncaXMxRYT8+GG1+tmZ+DMmqqzaLVn/SbDL7VV1VfcYocTCXOzGAkq" +
       "yZlcl2C5IuYxfK3dR0muF7ZdTfeHVRLhDLO20Lui2w54rtgq6eOgMxkZYpcb" +
       "L82ow08WjFNF7XkvDqe4o/OTWgHjWo7r9DuJsfanLWwgL3rmeCz0x0O9QsSh" +
       "hwUcy6WtdX1YGbYas00rkNBqPVLXYP2q1DXSX9jyhESHaGNU4kWDTZLpsmnX" +
       "B3VsVXFH48kKHZS4BttuWms66NVH08inewSd0k53pKBoRGGp1myEDj5ussiw" +
       "NqxxhmdOlbJJzGp24vgSj41W/oqWBpzQ65a6iT5Zkbhf0UhxusExuti3Z7hp" +
       "2lRgLDwetnhdqcKLSsQRLVIVWghreDLvTFR0tmIbzCQYDg1fH5Z9na5GBAvX" +
       "B1yHSFYr1RuRhDVW8WLS73guXJq02y0H9SvqUhnqNUftUWhpOVzoPRWlBZNr" +
       "MaOVndKk2Oe5Mldq93SP0vtEWvKSmb7qiC62RHlno+thvG56TpJKTLnc8Foc" +
       "M3Nmww42Jtz5pGavUNvAN5WgJiPV0B6VipPhbELNHJs0+5ONilkRXlBFPZjy" +
       "s3BTT32FLfi8RXbUZsys3AWq1xiZU1qtTntTV/r6KBUDpNkUOzrmLEmtnVZ7" +
       "xWJJIzUr4ZV+uzlC61OBUut1f2JZxb5JdSWJJC2LbPNUUnbTttiy6nUujZYz" +
       "ZqC4ITYqa7zbLaXhyLIXHbNvDRO5YwkFfVFSxNqoNqqQYwNHLaLIUwYzrpmN" +
       "CNdL8CwIppY7IhKsoSp0mLRQ0cSLIzotY4gQtwTSY+WAgWt6QWPqA0ydsx2h" +
       "V1P7VadnoCLStltGTSyOtFKn12RwUh/HKlKIxy05EdvrRbcYLqZIg8bYcMNa" +
       "UjcQemTKpzJnVjxqWSm7ZSnyl/XFhi2tnIY2XnVHcnlskaXyYk2up2TJqwwW" +
       "wUJfL6leC6PiyRxf9hkYJp05vOmqdXUsjNxGXWkNRbWokd2BPh4lqed7etS0" +
       "TYwxgI1IoxzSSNNGLHoY8I1EloPWGsfN1obpkptGrM7L8DTSmiozXdhVRakT" +
       "GM3yPWlYHU9GqRoR3IoLDbKcVDYYT26wFtYZLSrTYdPr9sk+H3SVeJDWhAbb" +
       "8Di4UOA7y06LF0QvJiZOXG9p9cZ0siYqtea6gAQyVqKNWYqVEU3iOjNuXjU9" +
       "TRZ9rs2sRnOtHzJCExbGLhMOqU1ZIMv8plYlp1LNLREhjwK31fr4oGhJQ7Ow" +
       "tha446OVlozUNknqiN1lJUrKmlZdtvE2skrBojcklBrScudVa6lWYdbxarLe" +
       "qxKDKbtayo0ApwZ124M9edBL1k0z7IYbncHbgjlE4k03hCfcYOgVk6QawViy" +
       "1NbdCdfe9Aw1cVujQWsQRRRFRrU1S07ZultU4Ej2uDE/qnnClPeL3Dgmk9GY" +
       "QO3VoLWsOsuhomFkN54uBJRIqxanVGIdjXoiS9sNfCyRKYwg/rhd6DohbNVT" +
       "tSRpjNMbjGqmLtKpAfeFGe0kIPlDGIt1Zg2XPacK12oeFhfHbkARSa8l1ybz" +
       "Tc1tyGUY5jUtSU1mHFKTNmvgRFljwrkUaB6cRpVOF8EQEUYJ3GXqCeI0arCs" +
       "DsXGhB3WRomNjvvqimmOBCK1GRktYrE0XiuDVNbXiNpwjVXNZTZaJQAJWhuY" +
       "5Q4hRNpMcDxadqIFWptN1I4Y9JyUl7DQQGvWCC0U6aZYj+QloaeR0ujYxWVL" +
       "iIh01BqMeayN9zlqonOLJGY8f2OV+WDOM2LU4i2ha6Izty5ONbm5aK4tWCij" +
       "61jVlYFiogQZxQ4zosrNqthQZJwo+EFXX6tmili9llv1qkaxsyjCm2WBi9AU" +
       "h5NFvFzokT+xcT+06vSytGwveyONjmfdtjluDupMpanOi91Zt5UUWiiuzmGd" +
       "wis8i7dnRD+paA2YrM2TAhvhG0JB2pUeNZEn5c00DXFERwb1+RpVHKfUWSUi" +
       "3GsWqbAxnM7X+HrQIPE5Mqiabi0UqO56WaorOkp5bBzqxcHK6TnVStC3i2jD" +
       "q1vYyBr0hKluzsaw0QlDlIzTcq+KxS6i9JBxo9ea9QWzKyadPl2p+Iq6cN11" +
       "B2wjOmVqCRfLhaIrc41hwSD5eiDqNAr3OgiGLrvMuGULYFnmxwxFWy7ju7jk" +
       "SyjZYLQ6w7RW3mok8GFMl5VJo2RKkQem7GbSJvg+EQ+mmOpgbbY6HQ4phOjB" +
       "9Yo66y78bt1rtgVLmYeJXMbHybDnWOW+Movocg31ZrIXO0UfXzHuSJhJ3JyZ" +
       "WE4JZqZSUpg4sKsmzZKnygonF1ilXEZq2jJW07VZ6lOdThvjq+qkOS/76rrn" +
       "FQtxuViPim1qIwBQbcLVdb/Wnvf1Lt4YEzOPQPSAZksMwiaRP1bcBLzdsBsE" +
       "4Fq5tEnXhFYopevOTLJ7xUaDCuYNRbBUHZ0O7aU5aMN1TSiPw/4oLdNWf+qu" +
       "0qlTIaMJ2qxGhY2PrNnFqA+3qzGcFmoExrphuIjlecQ1+sFIiptIZxRydGXe" +
       "mnAtZBNXGKlSq2goXlXmdEealOlZEE1pGOsR4SwKEKMWNztg2SaMWU+plfBN" +
       "e46zG3E+YDCpjyST8nAWRshgvqWHRcJeO8rU0ExuZRuxNkrtiWNO53EZN3rs" +
       "EExOaQ5jtTpJW9R6XpmgakWbrNE5XrHLzpwVu8PSNDVmc62iGIqWDMRObMhp" +
       "31iF9XWJxZQZaRZXCF2VilrUxyO8vsTHGrwojonCtGGX1huwL2u0eiWE5qsA" +
       "LlEqQfojU5t1KKwlxTNmCqZJhTUX7GrdXlPNol/EuIraafdZXCcpczBvG+NK" +
       "oT1Ymi4tDCpeYMiwUg2q1ThCmLLA6FXYXPXgBrIQGIyOiHmbA1Ec0fJgWa01" +
       "qixrhMoyMPwQcUuctELlbrm5UjwhkE3MW66SfnMYrktiYU6HBa8AZGzseiFl" +
       "ia7GFYrEUOoJ5fUinuGCNQ3hBlMnLQ6GVRzGJk1Ulg3e6oZpOSzI87VM9trW" +
       "ivBlvOHr0op1CsuijGx6MeNjxhxu2GEhSiZGp1pVbbzaXTvUypQVNhTjoFPt" +
       "Sf2ONaXbSMWboqFOSWRiszbdt8b+oBKsWjqHdZ1SqKQlu2VynjFHjALCROEm" +
       "WFsJOqMLMKVxwBPxpDnFVn7YTXuu2pEoz0faYNlP4KDe95leV2ptRCRG+kuD" +
       "QRMlVpmW1k7I5ijqKVV7NZmEG4bsoMJGKSSyvW6YiuKvi9OQZiXgDbARa702" +
       "exV9y4t7Rb4tPw3Yv+sEb8ZZh/ki3oLjG5x/LA7O1vPPGejYjdnhs/WDM1Mo" +
       "O7R6xfUuNfMDqw+/7elnVOYjpeyIIGNkQ+g8eJf7GUtba9YhUTcBSY9e/3CO" +
       "zu90D85Av/C2f7ln/Dr9zS/iZuj+Y3oeF/m79LNf6r1Kec9J6NT+iehVt81H" +
       "mR4/eg56wdfCyHfGR05DX7Hv2Yt73nz1rmdfffyk6iCa1wtTHuRjx/x7p9nZ" +
       "7/fcoO/prPiVELploYXdo8dvBxn01AudoxyWmje886iBd4PnsV0DH/vJG/jM" +
       "Dfp+Mys+ABIMGMgcnOMdGPcbP65xWfSKu8YVf/LGffQGfc9mxUe20WP3j7SP" +
       "GfhbP4aBt2eN94Cnsmtg5Sdv4B/coO8zWfF7IXQudA/OM80D2z71YmyLQ+jW" +
       "o9fV2cXb3Vf9S2b7zw7l489cPHfXM/xf5ze2+/++OE9B5+aRZR2+6jhUP+P5" +
       "2nwL0Oe3Fx9e/vXHIfTQC9+mh9Dp/DtX/XNbzj8NoXtvxBlCN2Vfh1k+H0J3" +
       "XYclO1nOK4fpvxhCl47TA1Xy78N0Xw6hCwd0QNS2cpjkqyF0CpBk1b/wrnEq" +
       "vb1eik8cXTD243n7C8Xz0Brz8JGVIf9L1B6KR9s/RV1RPvEMOXjL87WPbG+v" +
       "FUtK00zKOQo6u71I318JHryutD1ZZ/BHfnDrJ8+/cm/VunWr8MEEOKTb/de+" +
       "J+7aXpjf7Kafuev3X/Pbz3wjPyT/P7NTgbWrJgAA");
}
