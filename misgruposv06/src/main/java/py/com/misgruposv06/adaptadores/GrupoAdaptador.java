package py.com.misgruposv06.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import py.com.misgruposv06.R;
import py.com.misgruposv06.datos.Grupo;

public class GrupoAdaptador extends BaseAdapter {
	
	private final Activity actividad;
	private final ArrayList<Grupo> lista;
	
	public GrupoAdaptador(Activity actividad, ArrayList<Grupo> lista){
		super();
		this.actividad = actividad;
		this.lista = lista;
	}
	
	@Override
	public View getView(int posicion, View vista, ViewGroup padre) {		
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_grupos_cercanos, null, true);

		/*TextView nombreElemento = (TextView) view.findViewById(R.id.nombre_elemento);
		nombreElemento.setText(lista.get(posicion).getNombre());
		
		TextView cantIntegrantes = (TextView) view.findViewById(R.id.cant_integrantes);
		cantIntegrantes.setText(""+lista.get(posicion).cantidadIntegrantes());*/
		return view;
	}
	
	@Override
	public int getCount() {		
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		if(lista != null){
			return lista.get(arg0);
		}
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		Grupo unGrupo = lista.get(arg0);
		return unGrupo.getId();
				
	}

	

}
