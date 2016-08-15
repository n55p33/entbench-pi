package org.apache.batik.ext.awt.image.codec.imageio;
public class TIFFTranscoderImageIOWriteAdapter implements org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.TIFFTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        org.apache.batik.ext.awt.image.spi.ImageWriter writer =
          org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
          getInstance(
            ).
          getWriterFor(
            "image/tiff");
        org.apache.batik.ext.awt.image.spi.ImageWriterParams params =
          new org.apache.batik.ext.awt.image.spi.ImageWriterParams(
          );
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int PixSzInch =
          (int)
            (25.4 /
               PixSzMM +
               0.5);
        params.
          setResolution(
            PixSzInch);
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
                  setCompressionMethod(
                    "PackBits");
            }
            else
                if ("deflate".
                      equals(
                        method)) {
                    params.
                      setCompressionMethod(
                        "Deflate");
                }
                else
                    if ("lzw".
                          equals(
                            method)) {
                        params.
                          setCompressionMethod(
                            "LZW");
                    }
                    else
                        if ("jpeg".
                              equals(
                                method)) {
                            params.
                              setCompressionMethod(
                                "JPEG");
                        }
                        else {
                            
                        }
        }
        try {
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
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
            writer.
              writeImage(
                rimg,
                ostream,
                params);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public TIFFTranscoderImageIOWriteAdapter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1YfWwcRxWfu/N37PgjiRPSxEkcJ5Id5zYRSWnltNR27ebS" +
                                                              "84diN4BDc5nbnfNtvLe72Z21zy6maVFJ4I8oCm6bfvkvVwXUNhWiAgStjCrR" +
                                                              "VgWklggoqCkSfxA+IhohlT8ClDczu7d7e/5o+IuTbm5v5r0377157/3e7IvX" +
                                                              "UbltoRai0zidNokd79PpMLZsovRq2LZHYS4lPxnD/zhxbfDOKKoYQ2uz2B6Q" +
                                                              "sU36VaIp9hjaquo2xbpM7EFCFMYxbBGbWJOYqoY+hjaodiJnaqqs0gFDIYzg" +
                                                              "GLaSqBFTaqlph5KEK4CirUnQROKaSN3h5a4kqpUNc9on3xQg7w2sMMqcv5dN" +
                                                              "UUPyFJ7EkkNVTUqqNu3KW2iPaWjT45pB4yRP46e0g64LjiQPlrig9ZX6j29e" +
                                                              "yDZwF6zDum5Qbp59lNiGNkmUJKr3Z/s0krNPo6+iWBKtCRBT1Jb0NpVgUwk2" +
                                                              "9az1qUD7OqI7uV6Dm0M9SRWmzBSiaEexEBNbOOeKGeY6g4Qq6trOmcHa7QVr" +
                                                              "hZUlJj6+R5p78kTD92KofgzVq/oIU0cGJShsMgYOJbk0sexuRSHKGGrU4bBH" +
                                                              "iKViTZ1xT7rJVsd1TB04fs8tbNIxicX39H0F5wi2WY5MDatgXoYHlPuvPKPh" +
                                                              "cbC12bdVWNjP5sHAGhUUszIY4s5lKZtQdYWibWGOgo1t9wMBsFbmCM0aha3K" +
                                                              "dAwTqEmEiIb1cWkEQk8fB9JyAwLQomjzskKZr00sT+BxkmIRGaIbFktAVc0d" +
                                                              "wVgo2hAm45LglDaHTilwPtcHD51/SD+sR1EEdFaIrDH91wBTS4jpKMkQi0Ae" +
                                                              "CMbajuQTuPm1c1GEgHhDiFjQ/OArN+7pbFl8S9DctgTNUPoUkWlKXkivfXdL" +
                                                              "b/udMaZGlWnYKjv8Ist5lg27K115EypMc0EiW4x7i4tHf/alM98lf42imgSq" +
                                                              "kA3NyUEcNcpGzlQ1Yt1HdGJhSpQEqia60svXE6gSnpOqTsTsUCZjE5pAZRqf" +
                                                              "qjD4f3BRBkQwF9XAs6pnDO/ZxDTLn/MmQqgSvqgDvhISnzgbKHpMyho5ImEZ" +
                                                              "66puSMOWwey3Jag4afBtVkpD1E9ItuFYEIJ798cPSIY1LmGIhSxxF1l24ikq" +
                                                              "qTkIAUmGiiSLZ9WQRhP9/aMW1m02bSXYbGLoC5ZKSbeCTQi6OAtH8/9FkTzz" +
                                                              "2LqpSAQOc0u4lGiQhYcNDdhT8pzT03fj5dQ7IkxZarm+pmgQ9IoLveJcL154" +
                                                              "Qa841yXO9Yq7esVX1QtFIlyd9Uw/EVcQFRNQX6DA17aPPHjk5LnWGAS0OVUG" +
                                                              "R8pIW4uArtcvQh5ypOTLTXUzO67ufyOKypKoCcvUwRrDrW5rHCqiPOEWjdo0" +
                                                              "QKCPRNsDSMQg1DJkokAhXA6RXClVxiSx2DxF6wMSPJxkFUFaHqWW1B8tXpp6" +
                                                              "5NjD+6IoWgw+bMtyqJuMfZhBRgEa2sJFZym59WevfXz5iVnDLz9FaOaBcAkn" +
                                                              "s6E1HDBh96Tkju341dRrs23c7dUADxRDOkPlbQnvUVTdujykYLZUgcEZw8ph" +
                                                              "jS15Pq6hWcuY8md4JDeyYYMIahZCIQU5yNw1Yj7321/++bPckx4e1QcaiRFC" +
                                                              "uwI1kAlr4tWu0Y/IUYsQoPvg0vC3Hr9+9jgPR6DYudSGbWzshdoHpwMefOyt" +
                                                              "0+9/eHXhStQPYQpNgJOGXirPbVn/CXwi8P0P+7K6xSZE/WrqdYvo9kIVNdnO" +
                                                              "u33doJ5qUEpYcLQ9oEMYqhkVpzXC8udf9bv2v/q38w3iuDWY8aKlc3UB/vxn" +
                                                              "etCZd078s4WLicgMz33/+WQCJNb5krstC08zPfKPvLf1qTfxcwA3UOJtdYbw" +
                                                              "qo24PxA/wIPcF/v4eCC09jk27LKDMV6cRoG+KyVfuPJR3bGPXr/BtS1u3ILn" +
                                                              "PoDNLhFF4hRgsz3IHTwU4b9stdlk48Y86LAxXKgOYzsLwg4sDn65QVu8CduO" +
                                                              "wbYylHF7yIKily8KJZe6vPJ3P32j+eS7MRTtRzWagZV+zBMOVUOkEzsLhThv" +
                                                              "fv4eocdUFQwN3B+oxEMlE+wUti19vn05k/ITmfnhxu8femH+Kg9LU8i4LShw" +
                                                              "Nx/b2dApwpY97s0XnMU/FR7Uer8BZwVkRvjzJoruKgEPWgAHFz+KEaMtiBXM" +
                                                              "/VuX6614X7jw6Ny8MvT8ftEBNRX3K33Qjr/063//PH7pD28vAWzV1DD3amSS" +
                                                              "aEWaw5ZFeDPA206/5n2w9uIff9Q23nMrUMPmWlYBE/Z/GxjRsTx0hFV589G/" +
                                                              "bB69O3vyFlBjW8idYZHfGXjx7ft2yxejvMcWgFHSmxczdQUdC5taBC4TOjOT" +
                                                              "zdTxnNtZCKM1LGra4Hu7G0YHwzknyjuPSTb0FVh5tNZ4LEuwhkpKjJ9ozIvF" +
                                                              "fbcaix7jFp5bfsfT42QYmCm8u/GIOleS7ssccqjpUG7jF0PqRopTR/p0Avvy" +
                                                              "MjHZoXOZJ9kwQlHNFEsjoaCF2le4M1tqDnBw0r11SLNNH048e+0lkU/hK0qI" +
                                                              "mJyb++Yn8fNzIrfEPW5nyVUqyCPuclzTBjbEWYbvWGkXztH/p8uzP/727Nmo" +
                                                              "iw/3U1Q2aajiLngHG0ZFnTr0PxZQNtFj5uGSvmr/yortppJbubhJyi/P11dt" +
                                                              "nH/gN7w2FG57tZDlGUfTAkkSTJgK0yIZlRtWKwDK5D+nlwqqFXpviirdJ26g" +
                                                              "KaRQaPg+jRSKyvlvkHcKGrmVeYFLLWSByzUD18rluCiKwRiknoUmeilqoIQx" +
                                                              "SHmGooYwJezPf4N0X4Pw9+mg+RIPQZKvg3QgYY9nTS/hGniaszcJcXFtzkdK" +
                                                              "YfIO0YKuEm0FlmDPyFzA3/p4pdcR733g9jJ/ZPChG7c/L3pWWcMzM/wtQRJV" +
                                                              "is64UL53LCvNk1VxuP3m2leqd3m5UtQzB3XjMQ/1hveXm0NNnN1W6OXeXzj0" +
                                                              "+i/OVbwHWX4cRTBF644H3rkIT0En6ABuHk/6yBl4a8i7y672p6fv7sz8/fe8" +
                                                              "A3GRdsvy9Cn5ygsP/uripgXoQtckIMx0heTHUI1q3zutHyXypDWG6lS7Lw8q" +
                                                              "ghQVawlU5ejqaYcklCRay5IPs/dB3C+uO+sKs+wyQ1FrabUqvQJCtzZFrB7D" +
                                                              "0RUOaAC1/kzR6ygPAR3TDDH4M4WjXF9qe0q+9xv1P7nQFOuHAlJkTlB8pe2k" +
                                                              "C+gafEPlw61bXMWdIpZKDpimd8eofdgUEf+UoGHzFEU63NkAELG/z3Jxz/BH" +
                                                              "Nsz/F94ebJ18FgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bC/Mzy/SL73+D972O89+O6+h/i94zmyg+SEAAA==");
}
