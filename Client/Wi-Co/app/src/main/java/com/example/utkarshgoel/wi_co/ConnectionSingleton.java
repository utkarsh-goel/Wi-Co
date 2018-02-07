package com.example.utkarshgoel.wi_co;

import java.io.PrintWriter;
import java.net.Socket;

/**
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


public class ConnectionSingleton {

    private static PrintWriter pwt;
    private static Socket socket;

    public static void setPrintWriter(PrintWriter _pwt) {
        ConnectionSingleton.pwt = _pwt;
    }

    public static PrintWriter getPrintWriter() {
        return ConnectionSingleton.pwt;
    }

    public static void setSocket(Socket _socket) {
        ConnectionSingleton.socket = _socket;
    }

    public static Socket getSocket() {
        return ConnectionSingleton.socket;
    }
}
/**
 * Created by Utkarsh Goel on 17-Nov-16.
 * ​Utkarsh Goel
 *ABV-Indian Institute of Information Technology & Management,
 *Gwalior-474 015, India
 */