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
public class powerpt_fragment extends Fragment {

    PrintWriter out = ConnectionSingleton.getPrintWriter();

    ImageButton next;
    ImageButton prev;
    ImageButton start;
    ImageButton end;
    ImageButton pen;

    public powerpt_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_powerpt_fragment, container, false);

        next = (ImageButton)view.findViewById(R.id.imageButton14);
        prev = (ImageButton)view.findViewById(R.id.imageButton13);
        start = (ImageButton)view.findViewById(R.id.imageButton2);
        end = (ImageButton)view.findViewById(R.id.imageButton12);
        pen = (ImageButton)view.findViewById(R.id.imageButton11);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.NEXT_SLIDE);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.PREV_SLIDE);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.START);
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.END);
            }
        });

        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.PEN);
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
