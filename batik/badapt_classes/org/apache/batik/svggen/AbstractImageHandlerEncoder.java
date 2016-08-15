package org.apache.batik.svggen;
public abstract class AbstractImageHandlerEncoder extends org.apache.batik.svggen.DefaultImageHandler {
    private static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    private java.lang.String imageDir = "";
    private java.lang.String urlRoot = "";
    private static java.lang.reflect.Method createGraphics = null;
    private static boolean initDone = false;
    private static final java.lang.Class[] paramc = new java.lang.Class[] { java.awt.image.BufferedImage.class };
    private static java.lang.Object[] paramo = null;
    private static java.awt.Graphics2D createGraphics(java.awt.image.BufferedImage buf) {
        if (!initDone) {
            try {
                java.lang.Class clazz =
                  java.lang.Class.
                  forName(
                    "org.apache.batik.ext.awt.image.GraphicsUtil");
                createGraphics =
                  clazz.
                    getMethod(
                      "createGraphics",
                      paramc);
                paramo =
                  (new java.lang.Object[1]);
            }
            catch (java.lang.ThreadDeath td) {
                throw td;
            }
            catch (java.lang.Throwable t) {
                
            }
            finally {
                initDone =
                  true;
            }
        }
        if (createGraphics ==
              null)
            return buf.
              createGraphics(
                );
        else {
            paramo[0] =
              buf;
            java.awt.Graphics2D g2d =
              null;
            try {
                g2d =
                  (java.awt.Graphics2D)
                    createGraphics.
                    invoke(
                      null,
                      paramo);
            }
            catch (java.lang.Exception e) {
                
            }
            return g2d;
        }
    }
    public AbstractImageHandlerEncoder(java.lang.String imageDir,
                                       java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          );
        if (imageDir ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_DIR_NULL);
        java.io.File imageDirFile =
          new java.io.File(
          imageDir);
        if (!imageDirFile.
              exists(
                ))
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_DIR_DOES_NOT_EXIST);
        this.
          imageDir =
          imageDir;
        if (urlRoot !=
              null)
            this.
              urlRoot =
              urlRoot;
        else {
            try {
                this.
                  urlRoot =
                  imageDirFile.
                    toURL(
                      ).
                    toString(
                      );
            }
            catch (java.net.MalformedURLException e) {
                throw new org.apache.batik.svggen.SVGGraphics2DIOException(
                  ERR_CANNOT_USE_IMAGE_DIR +
                  e.
                    getMessage(
                      ),
                  e);
            }
        }
    }
    protected void handleHREF(java.awt.Image image, org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          image.
            getWidth(
              null),
          image.
            getHeight(
              null));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
        java.awt.Graphics2D g =
          createGraphics(
            buf);
        g.
          drawImage(
            image,
            0,
            0,
            null);
        g.
          dispose(
            );
        saveBufferedImageToFile(
          imageElement,
          buf,
          generatorContext);
    }
    protected void handleHREF(java.awt.image.RenderedImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          image.
            getWidth(
              ),
          image.
            getHeight(
              ));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
        java.awt.Graphics2D g =
          createGraphics(
            buf);
        g.
          drawRenderedImage(
            image,
            IDENTITY);
        g.
          dispose(
            );
        saveBufferedImageToFile(
          imageElement,
          buf,
          generatorContext);
    }
    protected void handleHREF(java.awt.image.renderable.RenderableImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          (int)
            java.lang.Math.
            ceil(
              image.
                getWidth(
                  )),
          (int)
            java.lang.Math.
            ceil(
              image.
                getHeight(
                  )));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
        java.awt.Graphics2D g =
          createGraphics(
            buf);
        g.
          drawRenderableImage(
            image,
            IDENTITY);
        g.
          dispose(
            );
        saveBufferedImageToFile(
          imageElement,
          buf,
          generatorContext);
    }
    private void saveBufferedImageToFile(org.w3c.dom.Element imageElement,
                                         java.awt.image.BufferedImage buf,
                                         org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        java.io.File imageFile =
          null;
        while (imageFile ==
                 null) {
            java.lang.String fileId =
              generatorContext.
                idGenerator.
              generateID(
                getPrefix(
                  ));
            imageFile =
              new java.io.File(
                imageDir,
                fileId +
                getSuffix(
                  ));
            if (imageFile.
                  exists(
                    ))
                imageFile =
                  null;
        }
        encodeImage(
          buf,
          imageFile);
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            urlRoot +
            "/" +
            imageFile.
              getName(
                ));
    }
    public abstract java.lang.String getSuffix();
    public abstract java.lang.String getPrefix();
    public abstract void encodeImage(java.awt.image.BufferedImage buf,
                                     java.io.File imageFile)
          throws org.apache.batik.svggen.SVGGraphics2DIOException;
    public abstract java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gCsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8wrWX2fv7uvu5dl77LLYwPsArsLza7pN/aMn1lYGM94" +
       "PGPPw/bYY3vasMzLM+N5et6eBEKIGmgiUdQshKiwUitCW7QB0hY1VZV2o6hN" +
       "IqJIRKjvBmgjkZSggETog7bpmfH3vvd+dzeQWjrH4/P8v87v/M+Zv1/4VuWu" +
       "MKhUfc/e6bYXHWpZdLixm4fRztfCwyHdHEtBqKmYLYXhDJQ9qzz2hevf+/5H" +
       "jQeuVO4WKw9JrutFUmR6bjjVQs9ONJWuXD8t7duaE0aVB+iNlEhQHJk2RJth" +
       "9DRdecWZrlHlCfqYBAiQAAESoJIECD1tBTq9UnNjByt6SG4UbivvrxzQlbt9" +
       "pSAvqrzl/CC+FEjO0TDjkgMwwtXitwCYKjtnQeXNJ7zveb6B4Y9Voed+8T0P" +
       "/KM7KtfFynXT5QtyFEBEBCYRK/c5miNrQYiqqqaKlVe5mqbyWmBKtpmXdIuV" +
       "B0NTd6UoDrQTIRWFsa8F5ZynkrtPKXgLYiXyghP21qZmq8e/7lrbkg54fe0p" +
       "r3sOiaIcMHjNBIQFa0nRjrvcaZmuGlXedLHHCY9PjEAD0PUeR4sM72SqO10J" +
       "FFQe3OvOllwd4qPAdHXQ9C4vBrNEldffctBC1r6kWJKuPRtVHr7YbryvAq3u" +
       "LQVRdIkqr7nYrBwJaOn1F7R0Rj/fYt/xkZ9wSfdKSbOqKXZB/1XQ6dELnaba" +
       "Wgs0V9H2He97iv649Npf//CVSgU0fs2Fxvs2//Qnv/Putz/64m/v27zhJm04" +
       "eaMp0bPKp+X7v/xG7MnuHQUZV30vNAvln+O8NP/xUc3TmQ9W3mtPRiwqD48r" +
       "X5z+69UHPqt980rlGlW5W/Hs2AF29CrFc3zT1oKB5mqBFGkqVblXc1WsrKcq" +
       "94Bn2nS1fSm3XodaRFXutMuiu73yNxDRGgxRiOge8Gy6a+/42Zcio3zO/Eql" +
       "8gBIldeAVKvsP+V3VFlDhudokKRIrul60DjwCv5DSHMjGcjWgGRg9RYUenEA" +
       "TBDyAh2SgB0Y2nFFouuaC6EysHNJiSgHWAEpuSpgq+8qnqoFh4W9+f/fZsoK" +
       "nh9IDw6AOt54EQxssI5IzwZtn1Wei3v973zu2S9dOVkcR9KKKgiY/HA/+WE5" +
       "+eF+8sNLJq8cHJRzvrogYq9+oDwLwAAAyPue5H98+N4PP3YHsDs/vRNIvmgK" +
       "3RqnsVPgoEp4VID1Vl78RPrTwk/VrlSunAfcgnBQdK3oPi5g8gQOn7i40G42" +
       "7vUP/dH3Pv/x93mnS+4cgh8hwY09i5X82EURB56iqQAbT4d/6s3SF5/99fc9" +
       "caVyJ4AHAImRBEwYoM2jF+c4t6KfPkbHgpe7AMNrL3Aku6g6hrRrkRF46WlJ" +
       "qfv7y+dXARm/ojDxt4FkH9l8+V3UPuQX+av3tlIo7QIXJfq+k/c/9e9+74+R" +
       "UtzHQH39zNbHa9HTZ8ChGOx6CQOvOrWBWaBpoN1//sT4Fz72rQ/9tdIAQIvH" +
       "bzbhE0WOAVAAKgRi/hu/vf33X/2DT3/lyqnRRGB3jGXbVLITJovyyrVLmASz" +
       "ve2UHgAuNlh2hdU8MXcdTzXXpiTbWmGl//v6W+tf/JOPPLC3AxuUHJvR228/" +
       "wGn5j/QqH/jSe/77o+UwB0qxuZ3K7LTZHjEfOh0ZDQJpV9CR/fTvP/JLvyV9" +
       "CmAvwLvQzLUSwq6UMrhScv4a4ISUPYt97HC/jxXltVKlUNnmqTI/LOR2tOSO" +
       "etZutbx5YTAIJN8wlRDGKa6fKZpfkFoOihTZm8Kza+r8sj3j2zyrfPQr336l" +
       "8O1/8Z1SCOedo7MmxEj+03urLbI3Z2D4110EEFIKDdCu8SL71x+wX/w+GFEE" +
       "IyoAJEMuAMiTnTO4o9Z33fMffuM3X/veL99RuUJUrtmepBJSuXYr94JFo4UG" +
       "QMHMf9e79zaTXj3eIrLKidQqpdQq2d7WHi5/XQMEPnlr2CIK3+Z05T/8vzhb" +
       "/uB/+R83CKEErJts6Rf6i9ALn3w99sw3y/6nyFH0fjS7Ed6BH3jaF/6s82dX" +
       "Hrv7X12p3CNWHlCOnExBsuNiPYrAsQqPPU/giJ6rP+8k7T2Cp0+Q8Y0XUevM" +
       "tBcx63RbAc9F6+L52gWY+pFCykOQ6kcruH4Rpg4q5QNWdnlLmT9RZH+l1Mkd" +
       "UeUePzAT4EEAfAhLfzYCdJiuZB/hxJ+DzwFI/7dIxehFwd4BeBA78kLefOKG" +
       "+GALvErhfXZGzVbHi+aR0sSkNDrUNc85RNdgfG0WSG5Y4PIeSIu8VWT4ft7u" +
       "Le3rmRPu7ytK3wJS64j71i24n9yc+4PicVCKdAjINoudGTdLG6ldoGr6Mql6" +
       "M0hPH1H19C2oWr4Uqu6JA3vqedHNiFq9dKIeOvbbnjki6plbEPXszYm6UhJV" +
       "ZOQxZfcrgQZUfox6x8p++BRbA21dAPYhUx4mLhD/3pdJ/NtBetcR8e+6BfHG" +
       "Syb+qumaEe652uWgNA5MB2zQydE5AXrfg1+1PvlHv7I/A1xEoAuNtQ8/93N/" +
       "fviR566cOXk9fsPh52yf/emrJPGVJZ0Fpr/lslnKHsQ3Pv++f/4P3vehPVUP" +
       "nj9H9MEx+Vf+zf/53cNPfO13buKu3iN7nq1J7gXlmC9dOSUE0SAdNd1/30Q5" +
       "6S0g6FQ5RUYda+ju8tCuAAm89db6Kff9vbif/8zjv/dTzz/+9XKPu2qGAFrR" +
       "QL/JgfFMn2+/8NVv/v4rH/lc6V7eKUvhHmQvnrRvPEifOx+XFN/nn1fWeVKn" +
       "UlqeU59V/tnka1/+VP75F/a6KKaMKtVbXXnceOtS+M2XyOPMYfjPBj/24h//" +
       "V+HHC6soCHzFkUUdLdPrp8u07FQU/8xNvZ5n/GMN/uwly+tHzyvP1lw92i9H" +
       "58zE26hyBxBm8fh+PzuZ7oJ79tBZ2sAaLXzE47r9Gcn0Dk9uVkBldgPhQeWp" +
       "W0tpj0en+/1vffC/vX72jPHel3E4etMFo7o45D9kXvidwduUv32lcsfJ7n/D" +
       "tcv5Tk+f3/OvBVoUB+7s3M7/iF9+vX+viCJ7ayndC07rsftV/P6lS+r+TpF9" +
       "HGz4SiHmvVYuaf58VrmAE9nLBPGnQEKPcAK9BU783ZcM4nuI8MqWP+mfmPYZ" +
       "737vgN3GrD/7Es26yP5mkf1ckX3mRvstfn6kyD56o0EWv39hr73PFNkvXiLn" +
       "X72k7h8X2eeL7JN7Ki5p+8Ub9PX3bquv/WI9AMfFu+DD9mHpcvzaJcj9ozci" +
       "9+s2tvLEsWsoaEEIltITG7tdVF90YYYvmSCwpO8/VSztufrTP/+HH/3dv/X4" +
       "VwGUDit3JYX7DVbmGe2zcXEf+7MvfOyRVzz3tZ8vz8JAFcIH3vqn5e3Wv3x5" +
       "bL2+YIsvr5hoKYyY8viqqQVnN8O5O8GS0v/C3EYPvZtshBR6/KHrEoagQn1q" +
       "VbupxFu42iMTigpqGGlAGoYjaT+dYnyfTofMyhGZlWGE0FoRB2TSDrZttu3o" +
       "29Fypi+l7SojCdXD/Q1mzr0ttonmraCxMavTOJr79HLRUWF/PljMt6suJ8lL" +
       "aN1px4hcb7fhFmMsRGcGSVqnCUHQGEKgqgJBue3izZrppbBaJ3BiMzRlduD3" +
       "B8YiX6ooO3Cqk54y9vTA1xRB63WojjwLpippSsRYmpoTvCdNlYE+m46ERm01" +
       "dvgVcCgtj9ospRFV32wQSR3YkzXRz4bCMqA0xvb4xXY37PvONtu6PItGLby/" +
       "EzY9dqn5tCPPiJWD8dJsMBkynmWqYtupRqbfz+bRvMZV+clSW3FBj3dmuW0O" +
       "eMk3B41pjxK93XBmSVa6y+ktPOuJ3laubpfCjMVqsGjpyG7YU8gtjM2bfSZt" +
       "zRPXdmYhuTX0fiOdEvM57LgR0cOFueaP+6vtcrodwAuJHTSsqIlhA8yu98XY" +
       "Yp3VeOAJPS/HvECq4z11tJzvFoJMYCK3ldmtgM7mPDbLmczxdKdl0bNVhHOi" +
       "PucySXM5zuNgJqclxaznAp21J8uZGxjxljQt3Z7B1tymWvNpOjXwnmH1GqiN" +
       "ye3toD3PqkwNscaDkYOHs61P62YWRWamyvNN13QwJx2nME2YYm274TKXT9FN" +
       "jMmuP2KJedertzBOnNUlZIoRid+rpw4X2Dk+3KZkbx5a/X42xrgeIvjqdLCb" +
       "27JP+4jREMlFnPR02lv4vNX0MGmw2M4pCyW22iqm9Gi0bk9myz7k97r0dLQx" +
       "ddBvmFjpVKrVJmwadKOe0q1Z42Xux6ikpzgaxCuR3i03ZB8b1RB4wdi2W2cj" +
       "vlpt8IJjG32LEqnmbD6Xm3yLmG0kddar1SeuQnUaPYRuhuu4z6868azOYD1s" +
       "3M16uROqydhFhNTfbmhkJI2WtldPppE3osVRFawexIikkOvs0miyGQxZlp/U" +
       "1r7syEOpvtjV69KkZubUhJnCOwam6iTXbEHtQMK7HJOOFpZhSNTWb9L6FGYJ" +
       "VrKHTLSQt/NhPZVmGbEZDUZJf1AHBmLGaHdoOvN6qzkcotk28ntTZhtuBdZO" +
       "dEzv0T3M7Lvm0qam2wSOMU7BtVrmGT7qaYzR0qarGRSuOw4/n5B1jGex7Ujn" +
       "KU+SVVWos1VqEs58FE5Jz0X07jTeGH7Ap5PFZhs11oSCjnvbjcqwm/WsKXjr" +
       "KdSIeUyi526q2wusr2v1gTGf6j6jTZbQDHI6G18gXWXOGf2hsdlulNUOx8bC" +
       "1trVxtKIqzPBwOpA9XG4U3NeIXuiNAwsqudBacqzYQfV1+MelXKoQ8DDjetN" +
       "cQUaYJ3NFB1QaGuZa5ESIUG3a1tEg1xLNcxASct2RalO4vNWGKJsJ0DMRuzm" +
       "eU4qi3EWOh48sgaWyGEzKqYhoTVOJ7EiMfWok7RWI2FHeKkY6HNcyH2VWFhK" +
       "w1+uU4fIRsKK3K7adUDGOFMILXdxc5rUllY731mtMYK7MFTtisRqSnNLk013" +
       "bH+CBL02V5PhGconXUUarMk0iJpIo5Og3QUwN96ZRFwiSo7KzFRxY3cnXjKm" +
       "ERPquRiYaixvbTukqr3RoDFiuFCfsGIj6+ijiSvAk76qmhZpGCPP7U0dWaYy" +
       "OkcJlVwOtw4dc6IGuboQzxvbnYI1uuFMGMNkPXQlwuCaXItdx/JUN2srARG3" +
       "GtTutEKHHrA5DNu0z+teayu4rumsqWDoE0Ew4GBE9m2UVmFIgxFkiWwX9cBR" +
       "OlimZR20K5rwpJfh/ZRixlCaTZP1eqypa2WNb/yqHI4wt2qiCe9o84z0+f4W" +
       "tTa4vLQma9Ob7KZoADtd2yMggh3x/dF6RhImJEe7PKbJceBszCTu4fgCHuxq" +
       "iusRszXUGClRQrNIJqRdsz8ldmNSSRXGaFtZ7igtRFBharrz6S4ks8F4aeDA" +
       "oqkepW4nrM0sVIVh9ByfrXsjS2ylLh3UpkkyNaHp0KlZ4Srnh4ult2ssBBJr" +
       "BS5F74Z1daMgrQYFU5Q7MPhIrm94ZyptjS2V+01hwzBqlo/cRIqjUbZMSK7R" +
       "rAoqAsH1gTWYuKtqE5EMwRoEjXqLztS0Fg4hb7N0gt6AQVtYowq7Ytde5jWc" +
       "xEN01TAzUthsJu0e4yO20pPrrdEIGo/HoTFeJITYS/s7ZyrwpDaksSbfkVF/" +
       "RA5QdBZHtNwZxY180lnCW3/lDNQJNWnAlrILJnI0zrXadDPfcCLgHhLj0YaH" +
       "1sl6pTSDjticDciuiaDRbhIsZGKtZ1SMB3WolUE1KFloVDNb5hDFWX63aq1b" +
       "8LTaFqsdpqPsCLuRD8HY4wCZolDkRru0PRgvkAbYaegQduWkOpEypGo3G8zY" +
       "JjRCNhSY4Ot9bjvFQrqdyRbBtKtkqHfwWVg3aml3m9faZnXiz+s1B7egemZt" +
       "liHboFrSrt2h2vMq0Y6xVeB6qb1M2+OVaWh0Mu9nU9agR9VkNxZkLqtSmBg0" +
       "MCub+rE+abMi1qkN0GGS2juAebrWonmf6k1nBK2EwSgLpNhu5X57YTU3tDln" +
       "HJGobs3VpjtxdV6OapNZP+0k7GSjCTzNBo0FE3XHst6kaqFYD1t9sWHZu4xa" +
       "b5bJTspyrA6HnRh4SR10rA6ZzBesgNFEsTElOu1JRLgpwbq4sHQpxFsTGUyr" +
       "soNVk/lg3hJr8ZwV8mW2M6MuwBpiZdbclHFiS5w1d3xiGfiGo0JtkzaIVE3Z" +
       "iUVIQy6dkpE3qLdr5tSV1B6AfHbmD4UIyVNJNkzD0BNjsWgMw25GTqpcW+I2" +
       "JIHXh8A4ACSP8nk9Y6g8mll9DGnVKT70uj2p24VX66ilLKOoWu8223gKzVKV" +
       "Y6EmCpiP2VzqpO5IXllZI65mjcbcd6kZgGtBFJZcM2lgnX7eXTc8Olvp645h" +
       "4cLKaaOiI9RWWdJGKa45peitXY1gNq51OrveMp0CL4NR4Wqns15PufZqN2UW" +
       "ib9YuzInq8nagBEnxo0V4iGTXK+Jxlj0qlyQ21GqwTLH8sJCTWa9WBDGdA+4" +
       "n66tmF3gmM5FqDurj7QtcFDn7iDt18JmWEUwW0haXsdVEcFQahM5UCaePzPd" +
       "6cYM5H7YYtuWSG6VzGU4XkypoGWTRkAOR2RzhWrjTjNZI4krOsYAz3a0DUFM" +
       "A6p1O3U9J6sy6eU0y1VJcrDpqQg7oGFrMR64gsvvqEE7SWZNv4G0oWRFsfVR" +
       "dQeWWBM306RudEaQ1XF2aQMeyM4WGXfW6rwOsw1SDLqtVrcttttsGBD6bkU4" +
       "A1ikXZaRhWabxdtIsxOQuTSB0w2Leq67WEDtARciBLcNGMYdOp7dRwRTMAKB" +
       "muwyr9nVOoIiN9c+2HoSnffa/VmvSpBjzw1cN4lmsIxnkIl4MeYs+B7Ssjdt" +
       "u++2dQafk5w6RZDpmllOrawLB21mGrRxx+stkFETbuQz3+iKrc5iucvFIFHo" +
       "lDbl1bQ9yMI+2XccPug0U8xIlAncqfMTAsWdajsaKTKr5ch049o6YjJaE9ic" +
       "WJ1hA99ScmMIcLdTyxsSANMGHPNWja8uZXKT7tRtta4xTTLFWvB2wK1IFOmO" +
       "e9Nk3JW1idBcLaJ1E1KiRaZDE5MbbMU2yUJ0x9cio97cumCTwehxPm+21aa/" +
       "a4uutt01mq3hzKvP21uAtKrT6WDwruagBNi8tEBCu1GDWOcdqTYWA7rXGhiE" +
       "2KcQbo1hPYhy1dzoLVjHCdfEcrTbcYhGkXkbw7lJdY3PF63BDjEVagwJKmOg" +
       "kO/KHUFwlqQqd2IioXPCXbJ+nixXkhjsut0d5ICNpb5qM2MzVndDc9YZr8h+" +
       "qrZko51qzVW+IzOe6Q2TDJ+wYUYTbaLh9uPpBI86a2hKiA1OoYRaf2BOhmiw" +
       "mEv+ZjEWl/wsA35gG49d2eqxGi8tWwiGpT04UOvNbrvhJOESbpDt3m4lrlqB" +
       "1JtRqk+P6PpU59ZziRk4/FhacvRwLtF12FKJvuyFy4aid7pV31nBzmJHE7Yz" +
       "5Z0e1x9oZK2/W/XTPgzpPI0jOUJqzC4f1jdDZo2SaQOpgx1iKeu5tsailF4N" +
       "NFqUpUEqo3LDYEYjZ7sTmYURIBSRxZ1OgNcA+KEKlMk9dMuYaDrDx6vGiJRr" +
       "fcEcos221s5Dn11FQ3kSYfh20sjDoSCrMSHamAhR8mDZ1fTJxLBdoir7Ix5d" +
       "Skk42m5C3l3Hmy5wwZfmxltUuaGygB3OiGcJOrGNjr2IKWTWVPUUMdT1nNuG" +
       "kzzwGrXljuVzmsBXDQVX8XQhCg66ChEPJ02j4zJDJGQWqKUO8KgxdVvtXoNB" +
       "cn2k5B0cS0IE79eRjMoNndsJXujrEwMIWaEYm7OiQNdUCWs0bcNisnwz5plZ" +
       "d93h2W3DGjIcx5JGSjhMtkxnGrrFWSyE1ZbNQoP2YqPymNLA58RgFxia2uW7" +
       "CII28d0MHmsdfTZXJn0FEjSlNpz3ZCXO4h6PaXinzqX9wJw7cEaRbghoz2va" +
       "gjGqKrvcdDhURBVSQBe7cLGZ7jTVR5w0Ymt43DNiQcnHIyUU5619W9LTldGS" +
       "HFbrnuCIyZzsc8wSiwdwwwlCzqzteNsmkCHcIrnxOm7lOlEN2yi7m7WQaIx0" +
       "Ao50s7zfWEk5R6OTYKgYIs6FLQabEFqvqQkxToiIsOZ9erNYkAwziXGGbMBU" +
       "fyeL/QDNsmljOVP8Zi2MgSMzrbK4totHQ63V7erN7hAWOpStCJTCU/au2qCH" +
       "qtr2REmcOcuO5rlRNKd8jE2r22kOXJf+UsDAlul6k4TxabweJd2oy6oZF9p6" +
       "Qw05KpH9oTwjKHQ4NlrbXAyXgcMPPX7u");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("osLCsaOOaUSBbfAc2Wn2AwuZt0fpjAjELLK6+DxGFis1MRIpkeXNttsk29XF" +
       "qu9hzRChmmt+gIHDXa6nvj5v9hA1ljcScGeWeW5PlMFsTCK+xDYnwEGC+VGj" +
       "ubD6cgb2Am3Vpu2chb1cqHaTtp206lwVIbIGbYEtvm9QuixUZS13xLo9Spf1" +
       "VN7lcLdtiLXuhkARebeW61uYGZP+opq3bAjHg5Zb7YKzSmeNBMuok0lCl3WG" +
       "PGyxg7TRmvqqE7cUf8xPFKGXrLQ5XxM3A2vSp31KFzOYFVr4Gkt0dsLJqz6H" +
       "hnl3Zk53luOIQptp4u3RvDoM0OZ0vVpI88iw50uHsXGvjuAjbdJygJdhtTh8" +
       "sRjJpGKES1aSJ4N44CcBsZy1qXhmbRnJ6QBQrQkb1WpM4JDQOhocQ+kopC3d" +
       "1LEQRdF3vrO4SvvSy7vie1V5c3kSDPkXuLPMLrtLjipXpaMosNMgnPJzvXIh" +
       "uu7MvfiZEIpK8Y7pkVsFQJYvAz/9weeeV7lfrh+/9gmiyr2R5/9VW0s0+8xQ" +
       "9+5vpE/IeLQYvnjHSh2RQV28nj+Vwu3v5i8PonnjSTxA+cr9sBevi+AttQyN" +
       "Kwf42iW32n9YZP/xlu+fHzoZ/DQe51R3/+l2N7BnZ7sgovuLQgykDx+J6EMv" +
       "Q0QHQA9+4EWaEmnqTYV0x940j/m4/4SPUiwn7BUBSCmiHKqec1jEVGtH4c+g" +
       "rnpZcNI+QsMLjsKVSxK+c3M9FT8bZYP/WWTfjCrXjDJgkZz2iZvedSeeqZ4K" +
       "+U9+GEL+1JGQP/lyhFw8/ulLke5FE5xqrnpigkWb7xbZ94qhDu6+jZQOrhXZ" +
       "wTkpFZXfP5HIwZUfhkR+9UgiX/hLkciTFyQSlBIp3q4eCad4vJl4Xn078Txc" +
       "ZNcvE88DP4B4ynAbFqTfPBLPb7xc8QwuE88Js18/5fix23FczHDwSFR5XSgl" +
       "2jl0m3nEUcz1GfYf/QHYf0NR+ARIXz9i/+svg/3TV5xfuakMzsDuweEldcUO" +
       "efAkQDhdi3jArlmOVjvl8KkfBoffOOLwG39JHP7YJXXvKLLmnsNxoN3IYesH" +
       "4PDVReEApG8dcfitHyKHZ95Nf/14rd93HERRGGPJH3E7ky7efh+gUeUVWhmz" +
       "fgIEZ8y49wOI4LGisAHSd49E8N0fogguuB8PniAdboLtMzyK0j2YXaL/ZZFx" +
       "oK8cm7Z6bkmfSraUwvjlSCGLKm+45I8BRZTzwzf8K2n/Txrlc89fv/q65+f/" +
       "dh+8dPxvl3vpytV1bNtno0fPPN/tnxjvvftY0jIm4eBZAFa38B6KwNDyoaD+" +
       "4D379nJUeeBi+6hyV/l9tp0GYP+0HRhq/3C2iRFV7gBNikfTv60rg2trKbbP" +
       "CSs7OO8iH6ui8uDtVHHGq378XLhQGVhyHNoTj49itz7//JD9ie+0fnkf1a/Y" +
       "Up4Xo1ylK/fs/2BQDlqEB73llqMdj3U3+eT37//CvW899tPv3xN8auVnaHvT" +
       "zUPo+44flUHv+a+97p+84+8//wdlhMP/A5tAluLJNwAA");
}
