class SoundChip {
    javax.sound.sampled.SourceDataLine soundLine;
    SquareWaveGenerator channel1;
    SquareWaveGenerator channel2;
    VoluntaryWaveGenerator channel3;
    NoiseGenerator channel4;
    boolean soundEnabled = false;
    boolean channel1Enable = true;
    boolean channel2Enable = true;
    boolean channel3Enable = true;
    boolean channel4Enable = true;
    int sampleRate = 44100;
    int bufferLengthMsec = 200;
    public SoundChip() { super();
                         soundLine = initSoundHardware();
                         channel1 = new SquareWaveGenerator(sampleRate);
                         channel2 = new SquareWaveGenerator(sampleRate);
                         channel3 = new VoluntaryWaveGenerator(sampleRate);
                         channel4 = new NoiseGenerator(sampleRate); }
    public javax.sound.sampled.SourceDataLine initSoundHardware() { try {
                                                                        javax.sound.sampled.AudioFormat format =
                                                                          new javax.sound.sampled.AudioFormat(
                                                                          javax.sound.sampled.AudioFormat.Encoding.
                                                                            PCM_SIGNED,
                                                                          sampleRate,
                                                                          8,
                                                                          2,
                                                                          2,
                                                                          sampleRate,
                                                                          true);
                                                                        javax.sound.sampled.DataLine.Info lineInfo =
                                                                          new javax.sound.sampled.DataLine.Info(
                                                                          javax.sound.sampled.SourceDataLine.class,
                                                                          format);
                                                                        if (!javax.sound.sampled.AudioSystem.
                                                                              isLineSupported(
                                                                                lineInfo)) {
                                                                            java.lang.System.
                                                                              out.
                                                                              println(
                                                                                "Error: Can\'t find audio output system!");
                                                                            soundEnabled =
                                                                              false;
                                                                        }
                                                                        else {
                                                                            javax.sound.sampled.SourceDataLine line =
                                                                              (javax.sound.sampled.SourceDataLine)
                                                                                javax.sound.sampled.AudioSystem.
                                                                                getLine(
                                                                                  lineInfo);
                                                                            int bufferLength =
                                                                              sampleRate /
                                                                              1000 *
                                                                              bufferLengthMsec;
                                                                            line.
                                                                              open(
                                                                                format,
                                                                                bufferLength);
                                                                            line.
                                                                              start(
                                                                                );
                                                                            soundEnabled =
                                                                              true;
                                                                            return line;
                                                                        }
                                                                    }
                                                                    catch (java.lang.Exception e) {
                                                                        java.lang.System.
                                                                          out.
                                                                          println(
                                                                            "Error: Audio system busy!");
                                                                        soundEnabled =
                                                                          false;
                                                                    }
                                                                    return null;
    }
    public void setSampleRate(int sr) { sampleRate =
                                          sr;
                                        soundLine.
                                          flush(
                                            );
                                        soundLine.
                                          close(
                                            );
                                        soundLine =
                                          initSoundHardware(
                                            );
                                        channel1.
                                          setSampleRate(
                                            sr);
                                        channel2.
                                          setSampleRate(
                                            sr);
                                        channel3.
                                          setSampleRate(
                                            sr);
                                        channel4.
                                          setSampleRate(
                                            sr);
    }
    public void setBufferLength(int time) {
        bufferLengthMsec =
          time;
        soundLine.
          flush(
            );
        soundLine.
          close(
            );
        soundLine =
          initSoundHardware(
            );
    }
    public void outputSound() { if (soundEnabled) {
                                    int numSamples;
                                    if (sampleRate /
                                          28 >=
                                          soundLine.
                                          available(
                                            ) *
                                          2) {
                                        numSamples =
                                          soundLine.
                                            available(
                                              ) *
                                            2;
                                    }
                                    else {
                                        numSamples =
                                          sampleRate /
                                            28 &
                                            65534;
                                    }
                                    byte[] b =
                                      new byte[numSamples];
                                    if (channel1Enable)
                                        channel1.
                                          play(
                                            b,
                                            numSamples /
                                              2,
                                            0);
                                    if (channel2Enable)
                                        channel2.
                                          play(
                                            b,
                                            numSamples /
                                              2,
                                            0);
                                    if (channel3Enable)
                                        channel3.
                                          play(
                                            b,
                                            numSamples /
                                              2,
                                            0);
                                    if (channel4Enable)
                                        channel4.
                                          play(
                                            b,
                                            numSamples /
                                              2,
                                            0);
                                    soundLine.
                                      write(
                                        b,
                                        0,
                                        numSamples);
                                } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
