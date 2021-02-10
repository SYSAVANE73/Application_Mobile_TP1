package univavignon.fr.tp1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import univavignon.fr.tp1.data.Country;

public class DetailFragment extends Fragment {
    public static final String TAG = "DetailFragment";
    ImageView drapeau;
    TextView paysName;
    EditText capitales,langues,monnaies,populations,superficie;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        drapeau = view.findViewById(R.id.imgFile);
        paysName = view.findViewById(R.id.pays);
        capitales = view.findViewById(R.id.capital);
        langues = view.findViewById(R.id.langue);
        monnaies = view.findViewById(R.id.monnaie);
        populations = view.findViewById(R.id.population);
        superficie = view.findViewById(R.id.superficie);

        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());

        String uri = Country.countries[args.getCountryId()].getImgUri();
        Context c = drapeau.getContext();

        drapeau.setImageDrawable(c.getResources().getDrawable(c.getResources().getIdentifier (uri, null , c.getPackageName())));
        paysName.setText(Country.countries[args.getCountryId()].getName());
        capitales.setText(Country.countries[args.getCountryId()].getCapital());
        langues.setText(Country.countries[args.getCountryId()].getLanguage());
        monnaies.setText(Country.countries[args.getCountryId()].getCurrency());

        populations.setText(Integer.toString(Country.countries[args.getCountryId()].getPopulation()));
        superficie.setText(Integer.toString(Country.countries[args.getCountryId()].getArea()));

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetailFragment.this)
                        .navigate(R.id.action_DetailFragment_to_ListFragment);
            }
        });
    }
}
