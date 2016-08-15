package video; 

import java.util.Date;

modes {low <: mid; mid <: high; };

public class Main@mode<?->X> {
	int width = 0;
	int height = 0;

	public Main(int width, int height) {
		this.width = width;
		this.height = height;
	}

	attributor {
		if (ENT_Util.Battery.percentRemaining() >= 0.75) {
      return @mode<high>;
    } else if (ENT_Util.Battery.percentRemaining() >= 0.50) {
      return @mode<mid>;
    } else {
      return @mode<low>;
    }

	}

	public void execute(int timeout) {
		try {
			String recovstr = System.getenv("PANDA_RECOVER");
			boolean recover = true;
			if (recovstr != null && recovstr.equals("false")) {
				recover = false;
			} 

      RaspiVid@mode<?> dynvideo = new RaspiVid@mode<?>(this.width, this.height);
			RaspiVid@mode<low<=*<=X> v;
			int fps = 20;
			try {
				v = snapshot dynvideo ?mode[@mode<low>,@mode<X>];
			} catch (RuntimeException e) {
				v = snapshotforce dynvideo ?mode[@mode<low>,@mode<X>]; 
				if (recover) {
					fps = 10;
				}
    	} 


			v.TakeVideo("vid.mp4", fps, timeout);
		} catch (Exception e) {
      System.exit(e.hashCode());
    }
	}

  public static void main(String[] args) {
		if (args.length < 2) {
			System.err.format("usage: [WIDTH] [HEIGHT]\n", args[0]);
			System.exit(1);
		}


		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);

		ENT_Util.initModeFile();
		int PANDA_RUNS = Integer.parseInt(System.getenv("PANDA_RUNS"));

		for (int k = 0; k < PANDA_RUNS; k++) {

			long startStamp = (new Date()).getTime()/1000;

			Main@mode<?> maindyn2 = new Main@mode<?>(width, height);
			Main@mode<*> main2 = snapshot maindyn2 ?mode[@mode<low>,@mode<high>];

			main2.execute(120000);

			long endStamp = (new Date()).getTime()/1000;

			ENT_Util.writeModeFile(String.format("ERun %d: %d %d\n", k, startStamp, endStamp));

			try {
				Thread.sleep(30000);
			} catch (Exception e) {
				System.err.println(e);
			}

		} 

		ENT_Util.closeModeFile();
  }
}
