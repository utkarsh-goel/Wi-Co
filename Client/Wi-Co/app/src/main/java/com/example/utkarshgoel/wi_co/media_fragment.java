package com.example.utkarshgoel.wi_co;

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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.io.PrintWriter;


/**
 * A simple {@link Fragment} subclass.
 */
public class media_fragment extends Fragment {

    PrintWriter out = ConnectionSingleton.getPrintWriter();

    ImageButton play;
    ImageButton pause;
    ImageButton previous;
    ImageButton next;
    ImageButton voli;
    ImageButton vold;
    ImageButton fast;
    ImageButton slow;
    ImageButton quit;

    public media_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_vlc_fragment, container, false);

        play = (ImageButton)view.findViewById(R.id.imageButton);
        pause = (ImageButton)view.findViewById(R.id.imageButton3);
        fast = (ImageButton)view.findViewById(R.id.imageButton10);
        slow = (ImageButton)view.findViewById(R.id.imageButton9);
        previous = (ImageButton)view.findViewById(R.id.imageButton5);
        next = (ImageButton)view.findViewById(R.id.imageButton6);
        voli = (ImageButton)view.findViewById(R.id.imageButton8);
        vold = (ImageButton)view.findViewById(R.id.imageButton7);
        quit = (ImageButton)view.findViewById(R.id.imageButton4);

       play.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       out.println(Constants.PLAY);
                                   }
                               });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.PAUSE);
            }
        });
        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.FAST);
            }
        });
        slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.SLOW);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.PREVIOUS);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.NEXT);
            }
        });
        voli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.VOLI);
            }
        });
        vold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.VOLD);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.QUIT);
            }
        });

        return view;
    }

    /**
     * Created by Utkarsh Goel on 17-Nov-16.
     * ​Utkarsh Goel
     *ABV-Indian Institute of Information Technology & Management,
     *Gwalior-474 015, India
     */

}
