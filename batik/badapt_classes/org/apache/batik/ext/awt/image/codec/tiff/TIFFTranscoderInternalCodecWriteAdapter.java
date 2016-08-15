package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFTranscoderInternalCodecWriteAdapter implements org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.TIFFTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam params =
          new org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam(
          );
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int numPix =
          (int)
            (1000 *
               100 /
               PixSzMM +
               0.5);
        int denom =
          100 *
          100;
        long[] rational =
          { numPix,
        denom };
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] fields =
          { new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_RESOLUTION_UNIT,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_SHORT,
          1,
          new char[] { (char)
                         3 }),
        new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_X_RESOLUTION,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_RATIONAL,
          1,
          new long[][] { rational }),
        new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_Y_RESOLUTION,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_RATIONAL,
          1,
          new long[][] { rational }) };
        params.
          setExtraFields(
            fields);
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.TIFFTranscoder.
                  KEY_COMPRESSION_METHOD)) {
            java.lang.String method =
              (java.lang.String)
                hints.
                get(
                  org.apache.batik.transcoder.image.TIFFTranscoder.
                    KEY_COMPRESSION_METHOD);
            if ("packbits".
                  equals(
                    method)) {
                params.
                  setCompression(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam.
                      COMPRESSION_PACKBITS);
            }
            else
                if ("deflate".
                      equals(
                        method)) {
                    params.
                      setCompression(
                        org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam.
                          COMPRESSION_DEFLATE);
                }
                else {
                    
                }
        }
        try {
            int w =
              img.
              getWidth(
                );
            int h =
              img.
              getHeight(
                );
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                img.
                getSampleModel(
                  );
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageEncoder tiffEncoder =
              new org.apache.batik.ext.awt.image.codec.tiff.TIFFImageEncoder(
              ostream,
              params);
            int bands =
              sppsm.
              getNumBands(
                );
            int[] off =
              new int[bands];
            for (int i =
                   0;
                 i <
                   bands;
                 i++)
                off[i] =
                  i;
            java.awt.image.SampleModel sm =
              new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              w,
              h,
              bands,
              w *
                bands,
              off);
            java.awt.image.RenderedImage rimg =
              new org.apache.batik.ext.awt.image.rendered.FormatRed(
              org.apache.batik.ext.awt.image.GraphicsUtil.
                wrap(
                  img),
              sm);
            tiffEncoder.
              encode(
                rimg);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public TIFFTranscoderInternalCodecWriteAdapter() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1Ya2wU1xW+u+s3Nn7wLAHzMlQGZwea0CYySTGOHZaswcWG" +
       "KqZhuZ696x08OzPM3LHXpqQhSgTtD4QoSWgUyB9HaaskRFWjtmoTEUVqEqWt" +
       "lBS1TauQSv1R+kANqpT+oG16zr0zO7OzNo9/XWnvzNw559xzzj3nfOfOS1dJ" +
       "tWOTdmbwJJ+ymJPsM/ggtR2W7dWp4wzDXEZ9JkH/eeDKrnvjpGaEzM9TZ0Cl" +
       "DuvXmJ51RsgKzXA4NVTm7GIsixyDNnOYPUG5ZhojZJHmpAqWrqkaHzCzDAn2" +
       "UTtNWinntjbqcpbyBHCyIg2aKEITpSf6ujtNGlXTmgrIl4bIe0NvkLIQrOVw" +
       "0pI+RCeo4nJNV9Kaw7uLNtlomfrUmG7yJCvy5CF9i+eCnektFS5Y82rzp9dP" +
       "5VuECxZQwzC5MM/ZwxxTn2DZNGkOZvt0VnAOk0dJIk3mhYg56Uj7iyqwqAKL" +
       "+tYGVKB9EzPcQq8pzOG+pBpLRYU4WV0uxKI2LXhiBoXOIKGOe7YLZrB2Vcla" +
       "aWWFiU9tVM48c6DlBwnSPEKaNWMI1VFBCQ6LjIBDWWGU2U5PNsuyI6TVgM0e" +
       "YrZGdW3a2+k2RxszKHdh+3234KRrMVusGfgK9hFss12Vm3bJvJwIKO+pOqfT" +
       "MbB1cWCrtLAf58HABg0Us3MU4s5jqRrXjCwnK6McJRs7HgICYK0tMJ43S0tV" +
       "GRQmSJsMEZ0aY8oQhJ4xBqTVJgSgzcmyOYWiry2qjtMxlsGIjNANyldAVS8c" +
       "gSycLIqSCUmwS8siuxTan6u7tp48Yuww4iQGOmeZqqP+84CpPcK0h+WYzSAP" +
       "JGPjhvTTdPHrJ+KEAPGiCLGk+dHXr23rar/4jqS5Yxaa3aOHmMoz6szo/PeX" +
       "93bem0A16izT0XDzyywXWTbovekuWlBhFpck4suk//Linp8//Nj32d/ipCFF" +
       "alRTdwsQR62qWbA0ndkPMoPZlLNsitQzI9sr3qdILdynNYPJ2d25nMN4ilTp" +
       "YqrGFM/gohyIQBc1wL1m5Ez/3qI8L+6LFiGkFv5kLfy7iPxtxIGTJ5S8WWAK" +
       "VamhGaYyaJtov6NAxRkF3+aVUYj6ccUxXRtCUDHtMYVCHOSZ9wIzk05yRSvA" +
       "9isqVCNV4Voupwyn+vuHbWo4OGenMIoNqvciwVdtjbOeLLVgLonRaP2f6FFE" +
       "fy2YjMVgK5dHC4kOObjD1EFIRj3jbu+79krmPRmkmFiepzn5CqiWlKolhWqi" +
       "7IJqSaFaUqiWRNWSt6gaicWERgtRRRlYEBbjUGCgwjd2Dj2y8+CJNQmIaGuy" +
       "CvYUSdeUIV1vUIV86MioF9qapldf3vxWnFSlSRtVuUt1BK4eewxKojruVY3G" +
       "UcDAAIpWhaAIMdQ2VZaFSjgXJHlS6swJZuM8JwtDEnygxJKgzA1Ts+pPLp6d" +
       "PLbvG5viJF6OPrhkNRROZB9EzChhQ0e06swmt/n4lU8vPH3UDOpPGZz5KFzB" +
       "iTasicZM1D0ZdcMq+lrm9aMdwu31gA+cQj5D6W2PrlFW3rp9qEBb6sDgnGkX" +
       "qI6vfB838LxtTgYzIphbcVgk4xpDKKKgQJn7hqxzv/vVX+4SnvQBqTnUSQwx" +
       "3h0qgiisTZS71iAih23GgO6js4Pffurq8f0iHIFi7WwLduDYC8UPdgc8+OQ7" +
       "hz/8+PLMpXgQwhy6AHcUmqmisGXhZ/CLwf+/+MfChROygLX1elV0VamMWrjy" +
       "+kA3KKg6FBMMjo69BoShltPoqM4wf/7dvG7za38/2SK3W4cZP1q6bi4gmP/c" +
       "dvLYewf+1S7ExFQE9MB/AZlEiQWB5B7bplOoR/HYByu+8zY9B3gDNd7Rppko" +
       "20T4g4gN3CJ8sUmMd0fefQmHdU44xsvTKNR4ZdRTlz5p2vfJG9eEtuWdW3jf" +
       "B6jVLaNI7gIs1kG8wYcRccW3iy0clxRBhyXRQrWDOnkQdvfFXV9r0S9eh2VH" +
       "YFkVCrmz24bSVywLJY+6uvb3b761+OD7CRLvJw26SbP9VCQcqYdIZ04eanHR" +
       "+vI2qcdkHQwtwh/kBn7aVjGLG7Jy9q3uK1hcbM70j5f8cOuL5y+LCLVkTN7h" +
       "8YuH9WLsxKFLRjDe3lks+U38anzY9a8hv4VkxsT9Uk7uq4ASXkILD03KIaQj" +
       "DBu4Eyvm6rNEjzjz+Jnz2d0vbJbdUFt579IHrfnLv/nPL5Jn//juLDBXz03r" +
       "Tp1NML1Mc1iyDHoGRAsalL+P5p/+0086xrbfDurgXPtNcAWfV4IRG+ZGkagq" +
       "bz/+12XD9+cP3gaArIy4MyryewMvvfvgevV0XPTbEjsq+vRypu6wY2FRm8HB" +
       "wkAzcaZJBO3aUhjN89PvLi+MvhBNP1npRUzi0F9iFdHa4LPMwhrJmoTY0YQf" +
       "i5tuNxZ9xuUit4L+Z7ubQ1zLpvDJJ+q6kfRA5m6XWy4XNj4cUTdWnjrKrQns" +
       "K6rMwk0XMikOw5w0TGIaSQVt0nmD87OtFQASJ7wTiHK07ePx5668LPMpelyJ" +
       "ELMTZ771WfLkGZlb8ky3tuJYFeaR5zqhaQsOSczw1TdaRXD0//nC0Z9+9+jx" +
       "uFcC05xUTZiaPBfeg8NeWae2zllLw/WysoDiRK9V5OTzt9jQYsldWnFOl2dL" +
       "9ZXzzXVLzu/9ragQpfNfI+R6ztX1UKqE06bGsllOE+Y1SsSyxAX6qs5b7sfB" +
       "L3gRBh6W/C70frfCz0m1uIZ5wSHtN+YFLq2UBR7XEThizsXFSQLGMPWj0E/P" +
       "Rg2UMIYpj3HSEqWE9cU1TPcEhH9AB32YvAmTHAfpQIK3Jyw/4VpEmuNXhaQ8" +
       "QhdjlTB5j+xGbxJtJZZw+4guEF+A/NLrym9AcJA5v3PXkWtffEG2r6pOp6fF" +
       "F4M0qZVNcql8r55Tmi+rZkfn9fmv1q/zc6WsfQ7rJmIe6o1oNZdF+jmno9TW" +
       "fTiz9Y1fnqj5ALJ8P4lRThbsD31/kZ6CptAF3NyfDpAz9AVRNJrdnc9O3d+V" +
       "+8cfRAfiIe3yuekz6qUXH/n16aUz0JDOS0GYGVlWHCENmvPAlLGHqRP2CGnS" +
       "nL4iqAhSNKqnSJ1raIddlsqmyXxMO4rfhoRfPHc2lWbxXMPJmspqVXkahMZt" +
       "ktnbTdfICkADqA1myj5N+QjoWlaEIZgpbeXCStsz6gPfbP7ZqbZEP5SOMnPC" +
       "4msdd7SEruGvVQHcesVVHi8SmfSAZfnHjfo3LRnxz0oanOcktsGbDQERPp4T" +
       "4p4Ttzg8/z8I9uNliBYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5ecY6R+88ffe+lvPfzOvpf4vyAgU+wIiAAA=");
}
