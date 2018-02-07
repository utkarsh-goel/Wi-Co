import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Created by Utkarsh Goel on 17-Nov-16.
 * ​Utkarsh Goel
 *ABV-Indian Institute of Information Technology & Management,
 *Gwalior-474 015, India
 */

/*Copyright Utkarsh Goel
*Copyright infringement is the use of works protected by copyright law
* without permission, infringing certain exclusive rights granted to the copyright holder,
* such as the right to reproduce, distribute, display or perform the protected work, or to make derivative works.
* It is a punishable offence under Copyright Act, 1957
 */

public class WiCo_Server {

	private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader in = null;
	private static String line;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 9159;

	public static void main(String[] args) {
		boolean leftpressed=false;
		boolean rightpressed=false;

	    try{
            robot = new Robot();
			server = new ServerSocket(SERVER_PORT); //Create a server socket on port SERVER_PORT
			client = server.accept(); //Listens for a connection to be made to this socket and accepts it
			in = new BufferedReader(new InputStreamReader(client.getInputStream())); //the input stream where data will come from client
		}
		catch (IOException e) {
			System.out.println("Error in opening Socket");
			System.exit(-1);
		}
		catch (AWTException e) {
			System.out.println("Error in creating robot instance");
			System.exit(-1);
		}

		//read input from client while it is connected
	    while(isConnected){
	        try
	        {
                line = in.readLine(); //read input from client
                System.out.println(line); //print whatever we get from client

                if(line.equalsIgnoreCase("Connected to client"))
                    continue;

                //Exit if user ends the connection
                else if(line.equalsIgnoreCase("exit")){
                    isConnected=false;
                    server.close();
                    client.close();
                }

                //input will come in x,y format if user moves mouse on mousepad
                else if(line.contains(",")){
                    float movex=Float.parseFloat(line.split(",")[0]);//extract movement in x direction
                    float movey=Float.parseFloat(line.split(",")[1]);//extract movement in y direction
                    Point point = MouseInfo.getPointerInfo().getLocation(); //Get current mouse position
                    float nowx=point.x;
                    float nowy=point.y;
                    robot.mouseMove((int)(nowx+movex),(int)(nowy+movey));//Move mouse pointer to new location
                }

                //if user taps on trackpad to simulate a left click
                else if(line.contains("left_click")){
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                }

                //if user taps on trackpad to simulate a right click
                else if(line.contains("right_click")){
                    robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                }

                    /*
                     * Created by Utkarsh Goel on 17-Nov-16.
                     * ​Utkarsh Goel
                     *ABV-Indian Institute of Information Technology & Management,
                     *Gwalior-474 015, India
                     */

                //Media Control Options
                else if(line.equalsIgnoreCase("next")){
                    robot.keyPress(KeyEvent.VK_N);
                    robot.keyRelease(KeyEvent.VK_N);
                }


                else if(line.equalsIgnoreCase("previous")){
                    robot.keyPress(KeyEvent.VK_P);
                    robot.keyRelease(KeyEvent.VK_P);
                }

                else if(line.equalsIgnoreCase("play")){
                    robot.keyPress(KeyEvent.VK_SPACE);
                    robot.keyRelease(KeyEvent.VK_SPACE);
                }

                else if(line.equalsIgnoreCase("pause")){
                    robot.keyPress(KeyEvent.VK_SPACE);
                    robot.keyRelease(KeyEvent.VK_SPACE);
                }

                else if(line.equalsIgnoreCase("voli")){
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_UP);
                    robot.keyRelease(KeyEvent.VK_UP);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                }

                else if(line.equalsIgnoreCase("vold")){
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                }

                else if(line.equalsIgnoreCase("fast")){
                    robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                    robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
                }
                else if(line.equalsIgnoreCase("slow")){
                    robot.keyPress(KeyEvent.VK_MINUS);
                    robot.keyRelease(KeyEvent.VK_MINUS);
                }

                else if(line.equalsIgnoreCase("quit")){
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_F4);
                    robot.keyRelease(KeyEvent.VK_F4);
                    robot.keyRelease(KeyEvent.VK_ALT );
                }

                        /*
                         * Created by Utkarsh Goel on 17-Nov-16.
                         * ​Utkarsh Goel
                         *ABV-Indian Institute of Information Technology & Management,
                         *Gwalior-474 015, India
                         */

                //Controls for keyboard
                    else if(line.equalsIgnoreCase("A")){
                        robot.keyPress(KeyEvent.VK_A);
                        robot.keyRelease(KeyEvent.VK_A);
                    }
                    else if(line.equalsIgnoreCase("B")){
                        robot.keyPress(KeyEvent.VK_B);
                        robot.keyRelease(KeyEvent.VK_B);
                    }
                    else if(line.equalsIgnoreCase("C")){
                        robot.keyPress(KeyEvent.VK_C);
                        robot.keyRelease(KeyEvent.VK_C);
                    }
                    else if(line.equalsIgnoreCase("D")){
                        robot.keyPress(KeyEvent.VK_D);
                        robot.keyRelease(KeyEvent.VK_D);
                    }

                    else if(line.equalsIgnoreCase("E")){
                        robot.keyPress(KeyEvent.VK_E);
                        robot.keyRelease(KeyEvent.VK_E);
                    }
                    else if(line.equalsIgnoreCase("F")){
                        robot.keyPress(KeyEvent.VK_F);
                        robot.keyRelease(KeyEvent.VK_F);
                    }
                    else if(line.equalsIgnoreCase("G")){
                        robot.keyPress(KeyEvent.VK_G);
                        robot.keyRelease(KeyEvent.VK_G);
                    }
                    else if(line.equalsIgnoreCase("H")){
                        robot.keyPress(KeyEvent.VK_H);
                        robot.keyRelease(KeyEvent.VK_H);
                    }

                    else if(line.equalsIgnoreCase("I")){
                        robot.keyPress(KeyEvent.VK_I);
                        robot.keyRelease(KeyEvent.VK_I);
                    }
                    else if(line.equalsIgnoreCase("J")){
                        robot.keyPress(KeyEvent.VK_J);
                        robot.keyRelease(KeyEvent.VK_J);
                    }
                    else if(line.equalsIgnoreCase("K")){
                        robot.keyPress(KeyEvent.VK_K);
                        robot.keyRelease(KeyEvent.VK_K);
                    }
                    else if(line.equalsIgnoreCase("L")){
                        robot.keyPress(KeyEvent.VK_L);
                        robot.keyRelease(KeyEvent.VK_L);
                    }

                    else if(line.equalsIgnoreCase("M")){
                        robot.keyPress(KeyEvent.VK_M);
                        robot.keyRelease(KeyEvent.VK_M);
                    }
                    else if(line.equalsIgnoreCase("N")){
                        robot.keyPress(KeyEvent.VK_N);
                        robot.keyRelease(KeyEvent.VK_N);
                    }
                    else if(line.equalsIgnoreCase("O")){
                        robot.keyPress(KeyEvent.VK_O);
                        robot.keyRelease(KeyEvent.VK_O);
                    }
                    else if(line.equalsIgnoreCase("P")){
                        robot.keyPress(KeyEvent.VK_P);
                        robot.keyRelease(KeyEvent.VK_P);
                    }

                    else if(line.equalsIgnoreCase("Q")){
                        robot.keyPress(KeyEvent.VK_Q);
                        robot.keyRelease(KeyEvent.VK_Q);
                    }
                    else if(line.equalsIgnoreCase("R")){
                        robot.keyPress(KeyEvent.VK_R);
                        robot.keyRelease(KeyEvent.VK_R);
                    }
                    else if(line.equalsIgnoreCase("S")){
                        robot.keyPress(KeyEvent.VK_S);
                        robot.keyRelease(KeyEvent.VK_S);
                    }
                    else if(line.equalsIgnoreCase("T")){
                        robot.keyPress(KeyEvent.VK_T);
                        robot.keyRelease(KeyEvent.VK_T);
                    }

                    else if(line.equalsIgnoreCase("U")){
                        robot.keyPress(KeyEvent.VK_U);
                        robot.keyRelease(KeyEvent.VK_U);
                    }
                    else if(line.equalsIgnoreCase("V")){
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                    }
                    else if(line.equalsIgnoreCase("W")){
                        robot.keyPress(KeyEvent.VK_W);
                        robot.keyRelease(KeyEvent.VK_W);
                    }
                    else if(line.equalsIgnoreCase("X")){
                        robot.keyPress(KeyEvent.VK_X);
                        robot.keyRelease(KeyEvent.VK_X);
                    }

                    else if(line.equalsIgnoreCase("Y")){
                        robot.keyPress(KeyEvent.VK_Y);
                        robot.keyRelease(KeyEvent.VK_Y);
                    }
                    else if(line.equalsIgnoreCase("Z")){
                        robot.keyPress(KeyEvent.VK_Z);
                        robot.keyRelease(KeyEvent.VK_Z);
                    }
                    else if(line.equalsIgnoreCase("1")){
                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                    }

                    else if(line.equalsIgnoreCase("2")){
                        robot.keyPress(KeyEvent.VK_2);
                        robot.keyRelease(KeyEvent.VK_2);
                    }
                    else if(line.equalsIgnoreCase("3")){
                        robot.keyPress(KeyEvent.VK_3);
                        robot.keyRelease(KeyEvent.VK_3);
                    }
                    else if(line.equalsIgnoreCase("4")){
                        robot.keyPress(KeyEvent.VK_4);
                        robot.keyRelease(KeyEvent.VK_4);
                    }
                    else if(line.equalsIgnoreCase("5")){
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                    }

                    else if(line.equalsIgnoreCase("6")){
                        robot.keyPress(KeyEvent.VK_6);
                        robot.keyRelease(KeyEvent.VK_6);
                    }
                    else if(line.equalsIgnoreCase("7")){
                        robot.keyPress(KeyEvent.VK_7);
                        robot.keyRelease(KeyEvent.VK_7);
                    }
                    else if(line.equalsIgnoreCase("8")){
                        robot.keyPress(KeyEvent.VK_8);
                        robot.keyRelease(KeyEvent.VK_8);
                    }
                    else if(line.equalsIgnoreCase("9")){
                        robot.keyPress(KeyEvent.VK_9);
                        robot.keyRelease(KeyEvent.VK_9);
                    }
                    else if(line.equalsIgnoreCase("0")){
                        robot.keyPress(KeyEvent.VK_0);
                        robot.keyRelease(KeyEvent.VK_0);
                    }
                    else if(line.equalsIgnoreCase("SPACE")){
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                    }
                    else if(line.equalsIgnoreCase("BACKSPACE")){
                        robot.keyPress(KeyEvent.VK_BACK_SPACE );
                        robot.keyRelease(KeyEvent.VK_BACK_SPACE );
                    }
                    else if(line.equalsIgnoreCase("ENTER")){
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                    }

                        /*
                         * Created by Utkarsh Goel on 17-Nov-16.
                         * ​Utkarsh Goel
                         *ABV-Indian Institute of Information Technology & Management,
                         *Gwalior-474 015, India
                         */

                    //controls for MS-Powerpoint
                    else if(line.equalsIgnoreCase("NEXT_SLIDE")){
                        robot.keyPress(KeyEvent.VK_RIGHT);
                        robot.keyRelease(KeyEvent.VK_RIGHT);
                    }
                    else if(line.equalsIgnoreCase("PREV_SLIDE")){
                        robot.keyPress(KeyEvent.VK_LEFT);
                        robot.keyRelease(KeyEvent.VK_LEFT);
                    }
                    else if(line.equalsIgnoreCase("START")){
                        robot.keyPress(KeyEvent.VK_F5);
                        robot.keyRelease(KeyEvent.VK_F5);
                    }
                    else if(line.equalsIgnoreCase("END")){
                        robot.keyPress(KeyEvent.VK_ESCAPE);
                        robot.keyRelease(KeyEvent.VK_ESCAPE);
                    }

                    else if(line.equalsIgnoreCase("PEN")){
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_P);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyRelease(KeyEvent.VK_P);
                    }

	        }
	        catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
	        }
      	}
	}
}

/*
 * Created by Utkarsh Goel on 17-Nov-16.
 * ​Utkarsh Goel
 *ABV-Indian Institute of Information Technology & Management,
 *Gwalior-474 015, India
 */
