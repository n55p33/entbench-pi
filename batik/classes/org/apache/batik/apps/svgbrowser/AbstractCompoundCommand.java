package org.apache.batik.apps.svgbrowser;
public abstract class AbstractCompoundCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
    protected java.util.ArrayList atomCommands;
    public AbstractCompoundCommand() { super();
                                       this.atomCommands = new java.util.ArrayList(
                                                             ); }
    public void addCommand(org.apache.batik.apps.svgbrowser.UndoableCommand command) {
        if (command.
              shouldExecute(
                )) {
            atomCommands.
              add(
                command);
        }
    }
    public void execute() { int n = atomCommands.size();
                            for (int i = 0; i < n; i++) {
                                org.apache.batik.apps.svgbrowser.UndoableCommand cmd =
                                  (org.apache.batik.apps.svgbrowser.UndoableCommand)
                                    atomCommands.
                                    get(
                                      i);
                                cmd.
                                  execute(
                                    );
                            } }
    public void undo() { int size = atomCommands.
                           size(
                             );
                         for (int i = size -
                                1; i >= 0;
                              i--) { org.apache.batik.apps.svgbrowser.UndoableCommand command =
                                       (org.apache.batik.apps.svgbrowser.UndoableCommand)
                                         atomCommands.
                                         get(
                                           i);
                                     command.
                                       undo(
                                         );
                         } }
    public void redo() { int n = atomCommands.
                           size(
                             );
                         for (int i = 0; i <
                                           n;
                              i++) { org.apache.batik.apps.svgbrowser.UndoableCommand cmd =
                                       (org.apache.batik.apps.svgbrowser.UndoableCommand)
                                         atomCommands.
                                         get(
                                           i);
                                     cmd.
                                       redo(
                                         );
                         } }
    public boolean shouldExecute() { boolean shouldExecute =
                                       true;
                                     if (atomCommands.
                                           size(
                                             ) ==
                                           0) {
                                         shouldExecute =
                                           false;
                                     }
                                     int n =
                                       atomCommands.
                                       size(
                                         );
                                     for (int i =
                                            0;
                                          i <
                                            n &&
                                            shouldExecute;
                                          i++) {
                                         org.apache.batik.apps.svgbrowser.UndoableCommand command =
                                           (org.apache.batik.apps.svgbrowser.UndoableCommand)
                                             atomCommands.
                                             get(
                                               i);
                                         shouldExecute =
                                           command.
                                             shouldExecute(
                                               ) &&
                                             shouldExecute;
                                     }
                                     return shouldExecute;
    }
    public int getCommandNumber() { return atomCommands.
                                      size(
                                        );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "T3NLrSI4Vv71xM4Hjuy80UW6DCcTRjQ55UHCSAlI+BzJH3Z06qJ/e9AuzoJn" +
       "uXO4y8dvF8VYSxzhnhJje7H5HicTWZZJFhfm/E1PC98/U1pogedyR5TLx6+F" +
       "YqwlJD1QYuwn2OwHG7DAO0IquPVMqmCVI8eq8augGGsJMY+VGDuOze2gAoPl" +
       "qeCOM6CCKTg2B55eR47e8augGGsJMe8rMXY/NvdwUgd1n6Wkum2PMAunyiHk" +
       "Or9vq7Srve9NF1D6HTDCr+t8798CV0tqmsKoGsZw/EmzntZ/dga0jlkJmQ0P" +
       "dVRHx6/1YqwlNPubEmNPYfMIJ42DjDsBZp0l/sjAgQeK67Fcdv55KaHDR78I" +
       "HWY5mVbkrhSL/Ol5/9vY/zVIdx1sqJp2cOPzIovK/R9QC/lQ2lIUfxnqe6/U" +
       "DZaWhWZq7aLUzlZf5GTO6YI7RGnvh5DmBZv5T5w0F2QGf8cvP+2rcBRhWk4q" +
       "xLef7nVYzaPjpNJ+8ZP8GQ4JSPD1L7qbonz+e+lwqlIWzJtzh9x8ukP2pdrz" +
       "AomL+GPO9Wyrz6m3Thxcs+6aU1+63b57lBQ6NoazTILixL4GzWWac4vO5s5V" +
       "uXrhp/V3V893cWGyvWHPy872uUInWLCOJjUjVGmZ7bmC68VDlzz0212Vz0CK" +
       "tJmUUajKNudfjGR1C1L8zfH8IgyycnFj2LHwxzsuW5J+7yVx9UTyLpzC9APS" +
       "c4e3PLt3+qHWCJnUQyogh2JZcWNz5Q51PZNGjASpk83uLGwRZpGpEqjw6tH6" +
       "Kf5lJ/TiqLMu14s315y05ad6+ff9NYo2yowV6IQ4DdSIk7yewD+GjkfVWLoe" +
       "YvB6fDcSW214wdMAux2Ir9V1t6IkH+sCC2hhvMH2n+IVm0/+C/PH0ge0HwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4KKqvhVcrWNVtd4aVZ2X6pP3aPvJsvhEAj2o5ZqSJpU5f+RMtB//ZkV7Elwf" +
       "OBbtA2+9aP/yHm3/qiw+DayVAi+4JNdn3gq5qGO5qLders/do+31svhpIFek" +
       "3SbXz3wTcr2jrHweXNyxXNxbL9cv3qPtl8riFxLo7bHpp47aPzjkneLvwY3v" +
       "O5rsncn9+W9C7nIJgJ4Dl3wst/zWy/2Fe7T9p7L4tQS6aWjJMegcjhjuJPp9" +
       "1vF3XJXY//4bETtPoKfu8i1FeTD8ztu+6zp8i6T83Ks3Hnrq1eXvV58TnH4v" +
       "9DALPaSnjnP+HO/c/bUg0nSrku/hw6leUP19KYGefzPYBvh79lCJ8buHzr+f" +
       "QE/csTMIhvLvPO0fAIVepk2gB6r/83R/CGY7o0uga4eb8yRfAWoHJOXtfw1O" +
       "Fp+/+3crlxehKxfzilNjPv5mxjyXirznQgJRfbh3stin/PEp5OuvMpPv/xr+" +
       "U4fPKRRHLopylIdY6MHDlx2nCcO77zrayVjXhu/7+qM///B7T5KbRw8MnwXG" +
       "Od6eu/O3C303SKrDxeLfPfUL3/WvX/2j6uTs/wGSLXXEUSkAAA==");
}
