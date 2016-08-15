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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BtnhYvLHt3769X/w9Lezk7P/A8Jk1v1RKQAA");
}
