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
import android.widget.Button;

import java.io.PrintWriter;


/**
 * A simple {@link Fragment} subclass.
 */
public class keyboard_fragment extends Fragment {

    Button a;
    Button b;
    Button c;
    Button d;
    Button e;
    Button f;
    Button g;
    Button h;
    Button i;
    Button j;
    Button k;
    Button l;
    Button m;
    Button n;
    Button o;
    Button p;
    Button q;
    Button r;
    Button v;
    Button u;
    Button t;
    Button s;
    Button w;
    Button z;
    Button x;
    Button y;
    Button space;
    Button enter;
    Button bckspce;
    Button eight;
    Button five;
    Button one;
    Button four;
    Button seven;
    Button six;
    Button two;
    Button three;
    Button nine;
    Button zero;

    PrintWriter out = ConnectionSingleton.getPrintWriter();

    public keyboard_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_keyboard_fragment, container, false);

        space=(Button)view.findViewById(R.id.space);
        bckspce=(Button)view.findViewById(R.id.bckspce);
        enter=(Button)view.findViewById(R.id.enter);

        a=(Button)view.findViewById(R.id.buttonA);
        b=(Button)view.findViewById(R.id.buttonB);
        c=(Button)view.findViewById(R.id.buttonC);
        d=(Button)view.findViewById(R.id.buttonD);
        e=(Button)view.findViewById(R.id.buttonE);
        f=(Button)view.findViewById(R.id.buttonF);
        g=(Button)view.findViewById(R.id.buttonG);
        h=(Button)view.findViewById(R.id.buttonH);
        i=(Button)view.findViewById(R.id.buttonI);
        j=(Button)view.findViewById(R.id.buttonJ);
        k=(Button)view.findViewById(R.id.buttonK);
        l=(Button)view.findViewById(R.id.buttonL);
        m=(Button)view.findViewById(R.id.buttonM);
        n=(Button)view.findViewById(R.id.buttonN);
        o=(Button)view.findViewById(R.id.buttonO);
        p=(Button)view.findViewById(R.id.buttonP);
        q=(Button)view.findViewById(R.id.buttonQ);
        r=(Button)view.findViewById(R.id.buttonR);
        s=(Button)view.findViewById(R.id.buttonS);
        t=(Button)view.findViewById(R.id.buttonT);
        u=(Button)view.findViewById(R.id.buttonU);
        v=(Button)view.findViewById(R.id.buttonV);
        w=(Button)view.findViewById(R.id.buttonW);
        x=(Button)view.findViewById(R.id.buttonX);
        y=(Button)view.findViewById(R.id.buttonY);
        z=(Button)view.findViewById(R.id.buttonZ);
        one=(Button)view.findViewById(R.id.button1);
        two=(Button)view.findViewById(R.id.button2);
        three=(Button)view.findViewById(R.id.button3);
        four=(Button)view.findViewById(R.id.button4);
        five=(Button)view.findViewById(R.id.button5);
        six=(Button)view.findViewById(R.id.button6);
        seven=(Button)view.findViewById(R.id.button7);
        eight=(Button)view.findViewById(R.id.button8);
        nine=(Button)view.findViewById(R.id.button9);
        zero=(Button)view.findViewById(R.id.button0);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.aa);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.bb);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.cc);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.dd);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.ee);
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.ff);
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.gg);
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.hh);
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.ii);
            }
        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.jj);
            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.kk);
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.ll);
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.mm);
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.nn);
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.oo);
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.pp);
            }
        });
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.qq);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.rr);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.ss);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.tt);
            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.uu);
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.vv);
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.ww);
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.xx);
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.yy);
            }
        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.zz);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n9);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.n0);
            }
        });

        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.SPACE);
            }
        });
        bckspce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.BACKSPACE);
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.ENTER);
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
