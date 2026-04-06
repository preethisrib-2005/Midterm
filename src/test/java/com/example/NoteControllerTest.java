@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnNotes() throws Exception {
        mockMvc.perform(get("/api/notes"))
               .andExpect(status().isOk());
    }
}
