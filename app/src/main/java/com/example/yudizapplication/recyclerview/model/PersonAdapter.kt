import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.recyclerview.model.Person

class PersonAdapter(
    private val personList: List<Person>,
    private val clickListener: (Person) -> Unit) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>()
    {
    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.personName)
        val contactTextView: TextView = view.findViewById(R.id.contactTextView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.nameTextView.text = person.name
        holder.contactTextView.text = person.contactNumber

        holder.itemView.setOnClickListener {
            clickListener(person)
        }
    }

    override fun getItemCount() = personList.size
}
