package org.apache.batik.ext.awt.image.codec.util;
public final class FileCacheSeekableStream extends org.apache.batik.ext.awt.image.codec.util.SeekableStream {
    private java.io.InputStream stream;
    private java.io.File cacheFile;
    private java.io.RandomAccessFile cache;
    private int bufLen = 1024;
    private byte[] buf = new byte[bufLen];
    private long length = 0;
    private long pointer = 0;
    private boolean foundEOF = false;
    public FileCacheSeekableStream(java.io.InputStream stream) throws java.io.IOException {
        super(
          );
        this.
          stream =
          stream;
        this.
          cacheFile =
          java.io.File.
            createTempFile(
              "jai-FCSS-",
              ".tmp");
        cacheFile.
          deleteOnExit(
            );
        this.
          cache =
          new java.io.RandomAccessFile(
            cacheFile,
            "rw");
    }
    private long readUntil(long pos) throws java.io.IOException {
        if (pos <
              length) {
            return pos;
        }
        if (foundEOF) {
            return length;
        }
        long len =
          pos -
          length;
        cache.
          seek(
            length);
        while (len >
                 0) {
            int nbytes =
              stream.
              read(
                buf,
                0,
                (int)
                  java.lang.Math.
                  min(
                    len,
                    bufLen));
            if (nbytes ==
                  -1) {
                foundEOF =
                  true;
                return length;
            }
            cache.
              setLength(
                cache.
                  length(
                    ) +
                  nbytes);
            cache.
              write(
                buf,
                0,
                nbytes);
            len -=
              nbytes;
            length +=
              nbytes;
        }
        return pos;
    }
    public boolean canSeekBackwards() { return true; }
    public long getFilePointer() { return pointer; }
    public void seek(long pos) throws java.io.IOException { if (pos <
                                                                  0) {
                                                                throw new java.io.IOException(
                                                                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                                    getString(
                                                                      "FileCacheSeekableStream0"));
                                                            }
                                                            pointer =
                                                              pos;
    }
    public int read() throws java.io.IOException {
        long next =
          pointer +
          1;
        long pos =
          readUntil(
            next);
        if (pos >=
              next) {
            cache.
              seek(
                pointer++);
            return cache.
              read(
                );
        }
        else {
            return -1;
        }
    }
    public int read(byte[] b, int off, int len)
          throws java.io.IOException { if (b ==
                                             null) {
                                           throw new java.lang.NullPointerException(
                                             );
                                       }
                                       if (off <
                                             0 ||
                                             len <
                                             0 ||
                                             off +
                                             len >
                                             b.
                                               length) {
                                           throw new java.lang.IndexOutOfBoundsException(
                                             );
                                       }
                                       if (len ==
                                             0) {
                                           return 0;
                                       }
                                       long pos =
                                         readUntil(
                                           pointer +
                                             len);
                                       len =
                                         (int)
                                           java.lang.Math.
                                           min(
                                             len,
                                             pos -
                                               pointer);
                                       if (len >
                                             0) {
                                           cache.
                                             seek(
                                               pointer);
                                           cache.
                                             readFully(
                                               b,
                                               off,
                                               len);
                                           pointer +=
                                             len;
                                           return len;
                                       }
                                       else {
                                           return -1;
                                       } }
    public void close() throws java.io.IOException {
        super.
          close(
            );
        cache.
          close(
            );
        cacheFile.
          delete(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TYMHq+tC+6DITv6IT9K/AVidGUHIJwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ius2SZNZQ4OxoS+lE3jRrkpsOuoMoGZ1PtwO59s2Hww66bS83mJEWzK1kA6z" +
       "FK30BX3lQZVqJG3I1bKh2Y4gOMNkow40p1smBCEUg54qyg4UZcuZzIKZnUJA" +
       "bkINOzqX8jHRjhqxLOKhn2QDJO2DSLRQDYNsoim0wSXYERGFY2ylNmftbXnT" +
       "TL32ukJ1M35tVgYLfeSMnRRBENuLsOaKB/nKCqOxdXfAr1ccSsOThIciUmBc" +
       "2+9rkThU+gu0JnAgL+sTSXOaZSpX7bJ0qDaWkFWDxytH65WRjAwNPZFguFw2" +
       "hnFaJqtTRLDAZIWHm/bGGQ5QTYcod6NqIRE37JHiMlu0XhvI/qjOrEbEYONN" +
       "sgzkhsBG1cWiJda4wUb0EiVDg5hh0KBCpRkyl5qdWF4ilivEm3Y2HxEq2eJ7" +
       "RJ/rxxI96G/GZFXom1MiW3gkbivyUlYGEoVtq63pot7jGlW6upzReLO5kRs1" +
       "ToKwnp5ia7tqTdh01U+X65QKpa7mknN5tm37RLmh8KnGKq0q32b1urZxfG02" +
       "q9vjCZixVu5o05TUlKS2rl2p2FGXNSdKy4nbE6SBNHtbJLYMaJJxzlwhET8r" +
       "B+usxawqcD9ayW4XLsfjNFa0GjKeRVOBJMytN6RUvd2e1+OqSQ6bqGJQwkDb" +
       "WOjIgrFm1PWGRm1E1Xrbut9t6R4hKaLXJbywObaaI2tcBh64GfmqiWRVizMV" +
       "fD3e6D1vpIPVxZafo3HEeHKPGSj+ZiZirRHhO7A3HQfQyOwbrSYeVEIbC22k" +
       "GbTq42HQ8rmZsmAtVpD4WhjIK7jd2zhmtLLDVTyt2Ajd27aC9YxIBLbbq48b" +
       "cEXDoX5npFMyRnam5SW37cDsYqZWIHbVKKNsed2w4zhrxsGwkTV66EJeZbOV" +
       "sBRG00hQXD1Fet5iu0jStZWMxYRZS53ZfNTsCihGzNKsbtIRO4eEeX3cmSt+" +
       "dzkcrDGvh0FOEyRDrf6EaqZ9jZyCqSlul62uxVU6lgJ11NjReNZJ+GnFtAWt" +
       "N5lNzJWld2EZKICG0bqL9IgVCa2hgc9HsVUXqZVVJ5w5OWg1u9rAaLBW2JRx" +
       "pLZk28qCMx23ixjZIB1FvEljw61ped1JyOu9Onitbx22A5aQJknoQbKEVGY+" +
       "MZcrnK1zfTHFZpuBUx4ZmYhOB3x/4iemxzviOPR77aFR765ak2qjQhDypjXi" +
       "8WpnIYUmPhmKDC3GyJBZY71Zx17P7PagrlKQ5k7X1ajG1NrsfI2Yqw6ubbaG" +
       "KermtlvWmC6yDUVhSAfjGZkpczxKJpWy0sIorLeqmjwsgWUNPpj1NGmjcQZw" +
       "4m49BtYKWp2u5lOiAm2Vnj1j7bFiwFx33ZtXl+swG1itZrNVp8jGypiSoWfi" +
       "bQoe0pApSb2UmwnzKhmzDc+KGLsBJq0olpTZcsBvGQvfdjk9Wuk801u1qAUz" +
       "URd9qBOJEh8JOjq24bBWx7ckN0f9eTRaqhY8pal12o1QIzDavQE8nrbFLu4b" +
       "FD/B2nZ3w48pTE+3SaYlDoKv8HW9r0GkgU69TsPAsCUMY/CKECBlE+iIVyMq" +
       "TFJfQc1WjDdgZzJrYLYwgytqP217pKTJWyqAqpnLLbNGXR8Nq3Rb1/rbemOz" +
       "WlW0rZZMA8ZwtEGTBvFk2B44vhQhEphdpbTtV21mK2yXwEgyNBqmA2sLi0kW" +
       "tbYVTJ5nfJ1ytSrCQ0w6F8F6jYFq1TRbBJOeGmBUxlgKuRB01qMJfBVa5MLD" +
       "xhXSh1PXW/vNWlgByQsuN7YNaCtX1B6J1iNsoehg6V5WWWEQbyqtGrp2WLlq" +
       "LJ1VH0kNz6lEXtyvTsklQ3Ji1VI1rTPBTdwWeN3SmEjttWioXiM3relMrFbL" +
       "+LItMm2a01hTKvcJaBbPyZXq0t3xOpkiisFqDabS2xgrpSVNwAzuybhgacOq" +
       "b0068qKrdq15A2QPiIU0EX7BkKtyjJUbXYpPGxTfBsMsWCoxJSl63enk2zf/" +
       "+t62kB4tdssOTsnt7Rz94j3sHGV32sjf9XWwDVn85XuRxw5cHdmGPPIpvZR/" +
       "5Xr6rDNxxReuL3/m9TfV4U9Xz+/tL1tx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6YHYDz7maKnmHGnqUvH82QMYBZSnwCXuwRBP7oYeyn/HrdDTj0oUe28Fwe+c" +
       "TVAvCH43L/4dgB1qkjr1Yqs42PcTh5r/xrvt2R3dYz8h5uN5Zf4d99U9MV+9" +
       "VzF/8FQxj27p/8Ed3v3XvHgnLl1TJC8/7YVKir2Wwt33srcOZfzme5CxIMs/" +
       "/r62J+Nr77+M37nDu/+ZF9+KS48YWpx/xh4d2a4/lPCP3oOED+5L+MaehG+8" +
       "PxLeZqx/9m7G+ud58Sdx6b4IDOapX05S31IPpf7T9yD11dKeAX9lT+qvvO/j" +
       "eu7BdxH4XP61/dxFIFfunXm1cSDcuUvvh3C/vyfc778/wl04DPVJAbcoClGe" +
       "eDdZvy8vHjtd1sffq/k+Abo6v+Pd3d/fgXzh3YTLP3Kee2b3nbL4un+udCjd" +
       "s/ciXRaXnjjjCGt+Hu/J207a706HK1998+rlJ96c/ofdGYP9E9wPDEqX9cRx" +
       "jh6DOvJ8MQg13SrEf2B3KCooxPloXHrprk/cgiHNb7kk58o7figuXb8b/lxh" +
       "+f0oby0uPXNnXsBV3I9yIXHpybO44tIFUB6lbsWlD5xGDShBeZTyJphdTlKC" +
       "/ov7UbpX4tKVQ7q4dHH3cJSkA1oHJPkjGux/LGzd/cHm48aQnTueyhwExcfe" +
       "zdqOZD8vHDuGUPyvx/6RgWT33x63lK+9SbM//N3GT++O2SqOtN3mrVwelC7t" +
       "TvwWjebHDj5yZmv7bV0kX/reIz//wIv7+dQjO8CHDnoE27Onn2ntuUFcnELd" +
       "/rMnfuHjP/Pm7xXfOP8v3WM13YQzAAA=");
}
