package org.apache.batik.gvt.text;
public class TextPath {
    private org.apache.batik.ext.awt.geom.PathLength pathLength;
    private float startOffset;
    public TextPath(java.awt.geom.GeneralPath path) { super();
                                                      pathLength = new org.apache.batik.ext.awt.geom.PathLength(
                                                                     path);
                                                      startOffset =
                                                        0; }
    public void setStartOffset(float startOffset) { this.startOffset =
                                                      startOffset;
    }
    public float getStartOffset() { return startOffset; }
    public float lengthOfPath() { return pathLength.lengthOfPath(
                                                      ); }
    public float angleAtLength(float length) { return pathLength.
                                                 angleAtLength(
                                                   length); }
    public java.awt.geom.Point2D pointAtLength(float length) { return pathLength.
                                                                 pointAtLength(
                                                                   length);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZa2wU1xW+u37itw3mbQPG0GLIbqDQihpowNjBZA0bDFQ1" +
       "DzM7e3c9MDszzNy1105JCVIEiVREKQHaBv7UERSRQKuitGoTEdGWpHlISWjT" +
       "tApp00qlTVGDqqZVaZuec2dm57HetSyVlebu7J1zzr3n9Z1zZy/eJiWGTpqp" +
       "wkJsWKNGqFNhUUE3aLxDFgxjK8z1i6eKhL/tvrVpZZCU9pGaAcHoEQWDdklU" +
       "jht9pElSDCYoIjU2URpHjqhODaoPCkxSlT7SKBndKU2WRIn1qHGKBNsFPULq" +
       "BcZ0KZZmtNsSwEhTBHYS5jsJr/U/bo+QKlHVhh3y6S7yDtcTpEw5axmM1EX2" +
       "CoNCOM0kORyRDNae0cliTZWHk7LKQjTDQnvlFZYJNkZW5Jig5XLtx3ePDdRx" +
       "E0wWFEVlXD1jCzVUeZDGI6TWme2UacrYTx4lRRFS6SJmpDViLxqGRcOwqK2t" +
       "QwW7r6ZKOtWhcnWYLalUE3FDjMzzCtEEXUhZYqJ8zyChnFm6c2bQdm5WW1PL" +
       "HBWfWhw+cWp33feKSG0fqZWUXtyOCJtgsEgfGJSmYlQ31sbjNN5H6hVwdi/V" +
       "JUGWRixPNxhSUhFYGtxvmwUn0xrV+ZqOrcCPoJueFpmqZ9VL8ICyfpUkZCEJ" +
       "uk51dDU17MJ5ULBCgo3pCQHizmIp3icpcUbm+DmyOrY+BATAWpaibEDNLlWs" +
       "CDBBGswQkQUlGe6F0FOSQFqiQgDqjMzMKxRtrQniPiFJ+zEifXRR8xFQTeKG" +
       "QBZGGv1kXBJ4aabPSy7/3N606ugjygYlSAKw5zgVZdx/JTA1+5i20ATVKeSB" +
       "yVjVFjkpTH3hSJAQIG70EZs0z3/5zgNLmq++bNLMGoNmc2wvFVm/OBqreXN2" +
       "x6KVRbiNck01JHS+R3OeZVHrSXtGA4SZmpWID0P2w6tbfvalgxfoh0FS0U1K" +
       "RVVOpyCO6kU1pUky1R+kCtUFRuPdZBJV4h38eTcpg/uIpFBzdnMiYVDWTYpl" +
       "PlWq8t9gogSIQBNVwL2kJFT7XhPYAL/PaISQMrhIFVxzifnh34xsCw+oKRoW" +
       "REGRFDUc1VXU3wgD4sTAtgPhGET9vrChpnUIwbCqJ8MCxMEAtR4kB8G3mJ5b" +
       "YYjCkiEML+1eCc6gRpOHAgEw9mx/qsuQJRtUOU71fvFEel3nnef6XzXDCEPf" +
       "sgUjLbBWyFwrxNcKwVohXCtkr0UCAb7EFFzT9CV4Yh/kNIBq1aLeXRv3HGkp" +
       "giDShorBjEja4ikuHU7i22jdL15qqB6Zd3PptSApjpAGQWRpQcZasVZPAgqJ" +
       "+6xErYpB2XHQf64L/bFs6apI4wA++aqAJaVcHaQ6zjMyxSXBrk2YheH8lWHM" +
       "/ZOrp4ce2/6V+4Mk6AV8XLIEsArZowjTWThu9Sf6WHJrD9/6+NLJA6qT8p4K" +
       "Yhe+HE7UocUfBH7z9Ittc4Ur/S8caOVmnwSQzARIIUC7Zv8aHkRpt9EZdSkH" +
       "hROqnhJkfGTbuIIN6OqQM8Ojs57fT4GwqMQUmwxXm5Vz/BufTtVwnGZGM8aZ" +
       "TwuO/qt7tTO/euNPn+HmtgtFravC91LW7gInFNbAYajeCdutOqVA997p6Nef" +
       "un14B49ZoJg/1oKtOHYAKIELwcyPv7z/3fdvjt4IOnHOoDqnY9DkZLJK4jyp" +
       "KKAkrLbQ2Q+Amww4gFHTuk2B+JQSkhCTKSbWv2sXLL3yl6N1ZhzIMGOH0ZLx" +
       "BTjzM9aRg6/u/kczFxMQsbg6NnPITMSe7Eheq+vCMO4j89hbTd+4LpwB7Ae8" +
       "NaQRyiE0YOU6bmo6IzM4pzDEQkmqpkImiMuIHtytKzjd/Xxcjibh3IQ/W4nD" +
       "AsOdHt4MdLVJ/eKxGx9Vb//oxTtcH2+f5Y6GHkFrNwMQh4UZED/ND18bBGMA" +
       "6JZf3bSzTr56FyT2gUQRANjYrANuZjyxY1GXlP36pWtT97xZRIJdpEJWhXiX" +
       "wNOQTIL4p8YAQG5G+8IDpvuHymGo46qSHOVzJtAFc8Z2bmdKY9wdIz+Y9v1V" +
       "587e5HGomTJmcf4gVgEP7vJu3Un9C29/7hfnvnZyyKz3i/LjnY9v+r82y7FD" +
       "H/wzx+Qc6cboRXz8feGLT8/sWPMh53cgB7lbM7mVC2Db4V12IfX3YEvpT4Ok" +
       "rI/UiVZ3vF2Q05jIfdARGnbLDB2057m3uzNbmfYspM72w51rWT/YORUT7pEa" +
       "76t9+IbtBGmxLvveg28Bwm8e4iyf4mMbDvfZcFKm6RKcoKgPTyoLCGWkAlsb" +
       "qGlJNmAn46dzajq6OJuc0SyDibg4fh6HiLnw6rzR2+nVthmu+dbG5ufRdrup" +
       "LQ6bctXKx81IJbhCZ2af520osGj3pmMGFH8pBVg/aLW8y6J7xCOt0T+Y4T1j" +
       "DAaTrvF8+Kvb39n7Gq8k5dhebLVd6moeoA1xlbE6c+ufwCcA13/xwi3jhNk6" +
       "NnRY/evcbAOL6Vkwz3wKhA80vL/v6VvPmgr4k8pHTI+cePKT0NETZnkwT0Hz" +
       "cw4ibh7zJGSqg8Nu3N28Qqtwjq4/Xjrwo/MHDpu7avD29J1wZH32l/95LXT6" +
       "t6+M0VxCFqkCy+JcINsfTvF6x1Rp/RO1Pz7WUNQFrUk3KU8r0v407Y5706/M" +
       "SMdc7nLOV05KWsqhaxgJtIEXfGH+xQJhnnHCdXE2XPmnlPiOC+6q7qAwQas2" +
       "5TvRcYuOHjpxNr75maVBqwACUk1iqnafTAep7BKFb2maPIDew8+wDjq+V3P8" +
       "9z9sTa6bSA+Nc83jdMn4ew54uy1/7Pq3cv3Qn2duXTOwZwLt8Byflfwiv9Nz" +
       "8ZUHF4rHg/zAbsJ2zkHfy9TujZYKnbK0rnjjY763JV0K13LLr8v9IOZEji8k" +
       "so1ePlZfw2OFPv7cxaU+WqAjOojDMCM1gH29LhjE6T1W6uIXpHzxoCrFndAe" +
       "GQ/BC/cfONGh8fl0VtV6fDYHrtWWqqsnbqV8rAWMcLTAs2M4PAEGSnoMxK3r" +
       "GOPJe2WMJri6LI26Jm6MfKwFFP5WgWdncDjJSJXMa/rmRNR61+Eyxal7ZQps" +
       "AR629Hl44qbIxzpe9pwvYI8LOHybkWpo+2S6ljmtjssgo/fAIHi45aVhp6XV" +
       "zokbJB/reAa5UsAgz+NwGQyiqZLCbIPYzWKj9+QWRZpl6x1Lfff/YakMI+X2" +
       "6yQ85UzPeTFtvkwVnztbWz7t7LZ3eEXLvvCsgtqUSMuyuw933ZdqOk1IXNcq" +
       "sys3a/5LcC7N+3oLsBO/+I6vmvQ/YWTKWPSMFMHoprzOSJ2fEtod/u2m+zn0" +
       "5w4dI6XmjZvkdZAOJHj7hmY7pY47BQ8uIfPgkgl4e4ysexrHc4+rLZnvKef8" +
       "LwS79KbNPxH6xUtnN2565M5nnzHfs4iyMDKCUiqh9TJf+WTL97y80mxZpRsW" +
       "3a25PGmB3ejUmxt2smCWK0o7IJ41jI2ZvpcQRmv2XcS7o6tefP1I6VvQau4g" +
       "AYGRyTtyj3gZLQ19045IbosJrQ5/O9K+6JvDa5Yk/vobfogmZks6Oz99v3jj" +
       "3K63j08fbQ6Sym5SAj0czfCz5/phZQsVB/U+Ui0ZnRnYIkiRBNnTv9ZgGAv4" +
       "5wK3i2XO6uwsvqVjpCW3ec99t1khq0NUX6emlTiKgQ640pnx/LdhpUZFWtN8" +
       "DM6M64Aj4bA7g96AeOyP9GiafbYpuabxLN47Fvrs5dy/47c4fPA/e06azl4c" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "//8BNm2FoM8mAAA=");
}
