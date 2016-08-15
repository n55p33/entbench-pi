package org.apache.batik.svggen.font.table;
public class KerningPair {
    private int left;
    private int right;
    private short value;
    protected KerningPair(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        left =
          raf.
            readUnsignedShort(
              );
        right =
          raf.
            readUnsignedShort(
              );
        value =
          raf.
            readShort(
              );
    }
    public int getLeft() { return left; }
    public int getRight() { return right; }
    public short getValue() { return value; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YDWwUxxUe2/gXG/+AwfzYYGOIcMhdoKEVMiUBxwaTM1iY" +
                                                              "OIopmL29ubvFe7vL7px9NqVNqCLcqkWUGkLaBKkVKRSRgNqmbdQkpYraJEpa" +
                                                              "iUCbplVI1VYqbYoaVDWtStv0vZnd25/zHUJqe9LO7s289+a9N2++92bOXSel" +
                                                              "lklaqMZCbNygVqhbY/2SadFYlypZ1g7oG5YfL5H+svva1rXFpGyIzEpKVp8s" +
                                                              "WbRHoWrMGiLNimYxSZOptZXSGHL0m9Si5qjEFF0bIo2K1ZsyVEVWWJ8eo0gw" +
                                                              "KJkRUi8xZirRNKO9tgBGmiOgSZhrEt4QHO6MkGpZN8Zd8iYPeZdnBClT7lwW" +
                                                              "I3WRvdKoFE4zRQ1HFIt1Zkxyp6Gr4wlVZyGaYaG96hrbBVsia3Jc0Hah9oOb" +
                                                              "R5J13AWzJU3TGTfP2k4tXR2lsQipdXu7VZqy9pFPkZIImekhZqQ94kwahknD" +
                                                              "MKljrUsF2tdQLZ3q0rk5zJFUZsioECOtfiGGZEopW0w/1xkkVDDbds4M1i7J" +
                                                              "WiuszDHx2J3hqcd3132zhNQOkVpFG0B1ZFCCwSRD4FCailLT2hCL0dgQqddg" +
                                                              "sQeoqUiqMmGvdIOlJDSJpWH5HbdgZ9qgJp/T9RWsI9hmpmWmm1nz4jyg7H+l" +
                                                              "cVVKgK1zXVuFhT3YDwZWKaCYGZcg7myWGSOKFmNkcZAja2P7A0AArOUpypJ6" +
                                                              "dqoZmgQdpEGEiCppifAAhJ6WANJSHQLQZGRBXqHoa0OSR6QEHcaIDND1iyGg" +
                                                              "quSOQBZGGoNkXBKs0oLAKnnW5/rWdYf3a5u1YlIEOseorKL+M4GpJcC0ncap" +
                                                              "SWEfCMbqjshxae6Lk8WEAHFjgFjQfPeTN+5b2XLxVUGzcBqabdG9VGbD8qno" +
                                                              "rEuLulasLUE1KgzdUnDxfZbzXdZvj3RmDECYuVmJOBhyBi9u//HDj5yl7xWT" +
                                                              "ql5SJutqOgVxVC/rKUNRqbmJatSUGI31kkqqxbr4eC8ph++IolHRuy0etyjr" +
                                                              "JTNU3lWm8//gojiIQBdVwbeixXXn25BYkn9nDEJIOTykGp5mIn78zYgUTuop" +
                                                              "GpZkSVM0Pdxv6mi/FQbEiYJvk+EoRP1I2NLTJoRgWDcTYQniIEmdgdFEgmrh" +
                                                              "uI4IJUVVGn6AmiAq0S8pZghDzfh/TJJBS2ePFRXBIiwKQoAKu2ezrsaoOSxP" +
                                                              "pTd233h2+HURXrglbB8xEoJ5Q2LeEJ83JOYN4bwhPm/IMy8pKuLTzcH5xXrD" +
                                                              "ao3AvgfgrV4xsGvLnsm2Egg0Y2wGuBpJ23wJqMsFBwfRh+XzDTUTrVdXvVxM" +
                                                              "ZkRIgySztKRiPtlgJgCp5BF7M1dHITW5GWKJJ0NgajN1mcYAoPJlCltKhT5K" +
                                                              "TexnZI5HgpO/cKeG82ePafUnF0+MPTr46buLSbE/KeCUpYBnyN6PUJ6F7PYg" +
                                                              "GEwnt/bQtQ/OHz+gu7DgyzJOcszhRBvaggERdM+w3LFEem74xQPt3O2VANtM" +
                                                              "gm0GiNgSnMOHOp0OgqMtFWBwXDdTkopDjo+rWNLUx9weHqn1/HsOhMUs3Ibz" +
                                                              "4Wm39yV/4+hcA9t5IrIxzgJW8Azx8QHjqV/89A8f4e52kkmtpwoYoKzTA2Ao" +
                                                              "rIFDVb0btjtMSoHunRP9Xzp2/dBOHrNAsXS6Cdux7QLggiUENz/26r633716" +
                                                              "6kqxG+eMVBqmzmCD01gmaycOkZoCdsKEy12VAANVkICB0/6gBiGqxBXcgLi3" +
                                                              "/lm7bNVzfzpcJ0JBhR4nklbeWoDbP38jeeT13X9r4WKKZMzBrttcMgHss13J" +
                                                              "G0xTGkc9Mo++2fzEK9JTkCIAli1lgnKkLbK3OyrVBAmDcyp6aLukxfTUBhkQ" +
                                                              "zuoBzOYLu4aT3c3be3KZZzvMvdu6MzI1UCHOtxabZZZ38/j3p6fQGpaPXHm/" +
                                                              "ZvD9l25wU/2VmjdW+iSjU4QnNsszIH5eENw2S1YS6O65uPUTderFmyBxCCRy" +
                                                              "o7aZgLAZX2TZ1KXlv/zhy3P3XCohxT2kStWlWI/ENymphN1BrSSAc8a49z4R" +
                                                              "GWMV0NThV4ZkHUO4Y0gmpwNXZ/H0696dMhhfqYnvzfv2utMnr/IoNYSMhZy/" +
                                                              "BPOFD5V5ve8Cw9nLH/vZ6S8eHxMVw4r8aBjga/rHNjV68Dd/z3E5x8FpqpkA" +
                                                              "/1D43JMLuta/x/ldQELu9kxujgNQd3lXn039tbit7EfFpHyI1Ml2fT0oqWnc" +
                                                              "5kNQU1pO0Q01uG/cXx+KYqgzC7iLgmDomTYIhW5uhW+kxu+aAPphQUIa4Vls" +
                                                              "o8LiIPoVEf7Rx1nu4G0HNnc5YFNumAqcwWgAamYWEMoANWic+RMyJr2BdNSC" +
                                                              "5KmkACtH7bJydf8eebK9/3ciAOZPwyDoGs+EvzD41t43OBJXYHre4RjtSb6Q" +
                                                              "xj1poE7o/CH8iuD5Nz6oK3aI8qyhy64Rl2SLRAzggpEYMCB8oOHdkSevPSMM" +
                                                              "CIZdgJhOTn3uw9DhKYGt4qSxNKfY9/KI04YwB5uHULvWQrNwjp7fnz/w/TMH" +
                                                              "DgmtGvx1czccC5/5+b/eCJ349WvTFGolin1a9CImJEj/2giD7v9s7QtHGkp6" +
                                                              "ILH3koq0puxL096YPzzLrXTUs1juCcYNWds0XBhGijpgDURaxnYdNltF/N2b" +
                                                              "F8Q2+YN+LjxL7PhckifoRajcgU1/bnTn42ak1FQSSZ4UBwNaJm9TyyZ4Wu15" +
                                                              "WvNoqRXUMh83aDmKgMM5dtiBg6+HPd+7gAqSg5mz2vhXDi6BXsC4TF78KDPS" +
                                                              "UVWRXfjgvzISOCl5KxU3fRAM9uZ8h1ke6KcOTp2MbXt6FQY6Mu6G+ojpxl0q" +
                                                              "HaVqIBM1+zJRHz++u7D+zqyjv32+PbHxdo4G2Ndyi+If/y+GTdiRH1KCqrxy" +
                                                              "8I8LdqxP7rmNKn9xwEtBkd/oO/fapuXy0WJ+VyHyTc4dh5+p07+Nq0zK0qbm" +
                                                              "37hLs+ta62y7DntdO4IB7cYTj+b9/miuKsAaqOKc2gT/f77A2GFsDkEOS8BJ" +
                                                              "HjIS37JuQE/earcWLoywo9vg/Z/xe2EePCHblNDteyEfawFLnygw9hVsphip" +
                                                              "AC9szyKX64Zj/wM31OMYHrtW27asvn035GMtYOrXC4ydwearwg28FsP/luuG" +
                                                              "r/033JBhZKbnDgOL56acG1Nxyyc/e7K2Yt7JB9/ieJO9iasG5IinVdVb3nm+" +
                                                              "ywyTxhVuULUo9kSqvMBI263vVwDv+Zurf15wfgvqzkKcUM3hy8vyHUbm5WEB" +
                                                              "wBcfXvrnGakL0oMq/O2le4GRKpcORIkPL8kPoDwBEvy8aDjHuDp+PsGSOiRK" +
                                                              "6kyRP4lkF7nxVovsyTtLfXjNr8cdbE2LC/Jh+fzJLVv33/jo0+J+QFaliQmU" +
                                                              "MhOKHnFVkcXn1rzSHFllm1fcnHWhcpmTyeqFwu5GWeiJ5m5IrgaG14LAydlq" +
                                                              "zx6g3z617qWfTJa9CSXeTlIkwXF3Z+7hI2OkITHujOQWd5DL+JG+c8WXx9ev" +
                                                              "jP/5V/x4R0QxuCg//bB85fSuy0ebTsHRf2YvKYUkTTP8VHT/uLadyqPmEKlR" +
                                                              "rO4MqAhSFEn1VY6zcCdIeHHO/WK7sybbi7dLEOy5RXPunRwchceouVFPazGe" +
                                                              "sSCXuj2+e3snxaUNI8Dg9ngOFlFsHsrgakA8Dkf6DMM5U5RcMjgWyPlrqsv8" +
                                                              "E5sr/wGStTnyOhsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8/X8ZPj/AJ50ZZmgJQAA");
}
