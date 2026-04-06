@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteRepository repository;

    @GetMapping
    public List<Note> getAll() { return repository.findAll(); }

    @PostMapping
    public Note create(@RequestBody Note note) { return repository.save(note); }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note details) {
        Note note = repository.findById(id).orElseThrow();
        note.setTitle(details.getTitle());
        note.setContent(details.getContent());
        return repository.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
