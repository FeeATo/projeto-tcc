using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TCC.Mensagens
{
    public partial class frmNotas : Form
    {        
        //
        //
        // A aba Notas serve como um bloco de notas no sistema. O admin pode salvar mensagem 
        // para ler depois, ou para outros lerem.
        // 
        //                

        SqlConnection sqlCon;        
        string connectionString = ConnectionString.StringConexao();
        string output = "";
        int i = 0;
        MetodosUtilitarios MetodosUtilitarios = new MetodosUtilitarios();

        public frmNotas()
        {
            InitializeComponent();

            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            lblUsuario.Text = frmLogin.SetLoginName;
            lblNumeroMensagens.Text = MetodosUtilitarios.MsgQntd().ToString();
        }

        //pintar ao redor dos painels

        private void lblRedorDireito_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, lblRedorDireito.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void lblRedor_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, lblRedor.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void btnSair_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, btnSair.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void btnChangeProfile_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, btnChangeProfile.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void btnVoltar_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, btnVoltar.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        //hover e leave

        private void btnEditarUsuario_MouseEnter(object sender, EventArgs e)
        {
            btnEditarUsuario.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarUsuario.ForeColor = Color.White;
            
        }

        private void btnEditarUsuario_MouseLeave(object sender, EventArgs e)
        {
            btnEditarUsuario.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarUsuario.ForeColor = Color.FromArgb(0, 102, 204);
            
        }

        private void btnEditarServico_MouseEnter(object sender, EventArgs e)
        {
            btnEditarServico.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarServico.ForeColor = Color.White;
        }

        private void btnEditarServico_MouseLeave(object sender, EventArgs e)
        {
            btnEditarServico.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarServico.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnEditarAdm_MouseEnter(object sender, EventArgs e)
        {
            btnEditarAdm.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarAdm.ForeColor = Color.White;
        }

        private void btnEditarAdm_MouseLeave(object sender, EventArgs e)
        {
            btnEditarAdm.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarAdm.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnEditarPrestador_MouseEnter(object sender, EventArgs e)
        {
            btnEditarPrestador.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarPrestador.ForeColor = Color.White;
        }

        private void btnEditarPrestador_MouseLeave(object sender, EventArgs e)
        {
            btnEditarPrestador.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarPrestador.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnNotas_MouseEnter(object sender, EventArgs e)
        {
            btnNotas.BackColor = Color.FromArgb(0, 102, 204);
            btnNotas.ForeColor = Color.White;
            lblIndicador.BackColor = Color.FromArgb(0, 102, 204);
            lblIndicador.ForeColor = Color.White;
        }

        private void btnNotas_MouseLeave(object sender, EventArgs e)
        {
            btnNotas.BackColor = Color.FromArgb(227, 227, 227);
            btnNotas.ForeColor = Color.FromArgb(0, 102, 204);
            lblIndicador.BackColor = Color.FromArgb(227, 227, 227);
            lblIndicador.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnMensagens_MouseEnter(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(0, 102, 204);
            btnMensagens.ForeColor = Color.White;
            lblNumeroMensagens.BackColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.ForeColor = Color.FromArgb(227, 227, 227);
        }

        private void btnMensagens_MouseLeave(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(227, 227, 227);
            btnMensagens.ForeColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.BackColor = Color.FromArgb(227, 227, 227);
            lblNumeroMensagens.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void lblNumeroMensagens_MouseEnter(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(0, 102, 204);
            btnMensagens.ForeColor = Color.White;
            lblNumeroMensagens.BackColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.ForeColor = Color.FromArgb(227, 227, 227);
        }

        private void lblNumeroMensagens_MouseLeave(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(227, 227, 227);
            btnMensagens.ForeColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.BackColor = Color.FromArgb(227, 227, 227);
            lblNumeroMensagens.ForeColor = Color.FromArgb(0, 102, 204);
        }

        //navegação entre os formulários

        private void btnSair_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnVoltar_Click(object sender, EventArgs e)
        {
            Form f = new frmPaginaPrincipal();
            f.Show();
            this.Close();
        }

        private void btnChangeProfile_Click(object sender, EventArgs e)
        {
            Form f = new frmLogin();
            f.Show();
            this.Close();
        }
                      
        //carrega os textos salvos nos blocos
        public string LoadText(int id)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select texto from notas where id_notas="+id+" and visivel = 'sim'";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }

            if (output == null)
            {
                output = "nada meu querido";
            }

            return output;
        }

        public string VerifCriado(int id)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select visivel from notas where id_notas="+id+"";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr["visivel"].ToString();
            }

            return output;
        }

        //carrega as notas.
        private void frmNotas_Load(object sender, EventArgs e)
        {
            if(VerifCriado(1) == "sim")
            {
                textBox1.Visible = true;             
                btnEditar1.Visible = true;
                btnSalvarText1.Visible = true;
                btnDeletarText1.Visible = true;
                                
                textBox1.Text = LoadText(1);
                
                btnCriarNota1.Visible = false;
            }

            if (VerifCriado(2) == "sim")
            {
                textBox2.Visible = true;
                btnEditar2.Visible = true;
                btnSalvarText2.Visible = true;
                btnDeletarText2.Visible = true;

                textBox2.Text = LoadText(2);

                btnCriarNota2.Visible = false;
            }

            if (VerifCriado(3) == "sim")
            {
                textBox3.Visible = true;
                btnEditar3.Visible = true;
                btnSalvarText3.Visible = true;
                btnDeletarText3.Visible = true;

                textBox3.Text = LoadText(3);

                btnCriarNota3.Visible = false;
            }

            if (VerifCriado(4) == "sim")
            {
                textBox4.Visible = true;
                btnEditar4.Visible = true;
                btnSalvarText4.Visible = true;
                btnDeletarText4.Visible = true;

                textBox4.Text = LoadText(4);

                btnCriarNota4.Visible = false;
            }

            if (VerifCriado(5) == "sim")
            {
                textBox5.Visible = true;
                btnEditar5.Visible = true;
                btnSalvarText5.Visible = true;
                btnDeletarText5.Visible = true;

                textBox5.Text = LoadText(5);

                btnCriarNota5.Visible = false;
            }

            if (VerifCriado(6) == "sim")
            {
                textBox6.Visible = true;
                btnEditar6.Visible = true;
                btnSalvarText6.Visible = true;
                btnDeletarText6.Visible = true;

                textBox6.Text = LoadText(6);

                btnCriarNota6.Visible = false;
            }

        }

        private void btnEditar1_Click(object sender, EventArgs e)
        {
            textBox1.Enabled = true;

            btnEditar1.Enabled = false;
            btnDeletarText1.Enabled = false;
        }

        private void btnEditar2_Click(object sender, EventArgs e)
        {
            textBox2.Enabled = true;

            btnEditar2.Enabled = false;
            btnDeletarText2.Enabled = false;
        }

        private void btnEditar3_Click(object sender, EventArgs e)
        {
            textBox3.Enabled = true;

            btnEditar3.Enabled = false;
            btnDeletarText3.Enabled = false;
        }

        private void btnEditar4_Click(object sender, EventArgs e)
        {
            textBox4.Enabled = true;

            btnEditar4.Enabled = false;
            btnDeletarText4.Enabled = false;
        }

        private void btnEditar5_Click(object sender, EventArgs e)
        {
            textBox5.Enabled = true;

            btnEditar5.Enabled = false;
            btnDeletarText5.Enabled = false;
        }

        private void btnEditar6_Click(object sender, EventArgs e)
        {
            textBox6.Enabled = true;

            btnEditar6.Enabled = false;
            btnDeletarText6.Enabled = false;
        }

        public void SaveTexts(string textbox, int id)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "update notas set texto='" + textbox + "' where id_notas="+id+"";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            int up = cmd.ExecuteNonQuery();
            
            
        }

        private void btnSalvarText1_Click(object sender, EventArgs e)
        {
            SaveTexts(textBox1.Text, 1);
            textBox1.Enabled = false;

            btnEditar1.Enabled = true;
            btnDeletarText1.Enabled = true;
        }

        private void btnSalvarText2_Click(object sender, EventArgs e)
        {
            SaveTexts(textBox2.Text, 2);
            textBox2.Enabled = false;

            btnEditar2.Enabled = true;
            btnDeletarText2.Enabled = true;
        }

        private void btnSalvarText3_Click(object sender, EventArgs e)
        {
            SaveTexts(textBox3.Text, 3);
            textBox3.Enabled = false;

            btnEditar3.Enabled = true;
            btnDeletarText3.Enabled = true;
        }

        private void btnSalvarText4_Click(object sender, EventArgs e)
        {
            SaveTexts(textBox4.Text, 4);
            textBox4.Enabled = false;

            btnEditar4.Enabled = true;
            btnDeletarText4.Enabled = true;
        }

        private void btnSalvarText5_Click(object sender, EventArgs e)
        {
            SaveTexts(textBox5.Text, 5);
            textBox5.Enabled = false;

            btnEditar5.Enabled = true;
            btnDeletarText5.Enabled = true;
        }

        private void btnSalvarText6_Click(object sender, EventArgs e)
        {
            SaveTexts(textBox6.Text, 6);
            textBox6.Enabled = false;

            btnEditar6.Enabled = true;
            btnDeletarText6.Enabled = true;
        }

        public void DeleteText(int id)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "update notas set texto= '', visivel='não' where id_notas=" + id + "";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            int up = cmd.ExecuteNonQuery();
                                                          
                       
        }

        private void btnDeletarText1_Click(object sender, EventArgs e)
        {
            
            DialogResult result = MessageBox.Show("Você quer mesmo deletar este esta nota?", "Confirmação", MessageBoxButtons.OKCancel);
            if (result == DialogResult.OK)
            {
                DeleteText(1);
                textBox1.Text = "";
                textBox1.Visible = false;
                btnDeletarText1.Visible = false;
                btnSalvarText1.Visible = false;
                btnEditar1.Visible = false;

                btnCriarNota1.Visible = true;
            }
            
            
        }

        private void btnDeletarText2_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Você quer mesmo deletar este esta nota?", "Confirmação", MessageBoxButtons.OKCancel);
            if (result == DialogResult.OK)
            {
                DeleteText(2);
                textBox2.Text = "";

                textBox2.Visible = false;
                btnDeletarText2.Visible = false;
                btnSalvarText2.Visible = false;
                btnEditar2.Visible = false;

                btnCriarNota2.Visible = true;
            }

        }

        private void btnDeletarText3_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Você quer mesmo deletar este esta nota?", "Confirmação", MessageBoxButtons.OKCancel);
            if (result == DialogResult.OK)
            {
                DeleteText(3);
                textBox3.Text = "";

                textBox3.Visible = false;
                btnDeletarText3.Visible = false;
                btnSalvarText3.Visible = false;
                btnEditar3.Visible = false;

                btnCriarNota3.Visible = true;
            }
        }

        private void btnDeletarText4_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Você quer mesmo deletar este esta nota?", "Confirmação", MessageBoxButtons.OKCancel);
            if (result == DialogResult.OK)
            {
                DeleteText(4);
                textBox4.Text = "";

                textBox4.Visible = false;
                btnDeletarText4.Visible = false;
                btnSalvarText4.Visible = false;
                btnEditar4.Visible = false;

                btnCriarNota4.Visible = true;
            }
        }

        private void btnDeletarText5_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Você quer mesmo deletar este esta nota?", "Confirmação", MessageBoxButtons.OKCancel);
            if (result == DialogResult.OK)
            {
                DeleteText(5);
                textBox5.Text = "";

                textBox5.Visible = false;
                btnDeletarText5.Visible = false;
                btnSalvarText5.Visible = false;
                btnEditar5.Visible = false;

                btnCriarNota5.Visible = true;
            }
        }

        private void btnDeletarText6_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Você quer mesmo deletar este esta nota?", "Confirmação", MessageBoxButtons.OKCancel);
            if (result == DialogResult.OK)
            {
                DeleteText(6);
                textBox6.Text = "";

                textBox6.Visible = false;
                btnDeletarText6.Visible = false;
                btnSalvarText6.Visible = false;
                btnEditar6.Visible = false;

                btnCriarNota6.Visible = true;
            }
        }

        public bool CriarNotas(int id)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "update notas set visivel='sim' where id_notas=" + id + "";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            int up = cmd.ExecuteNonQuery();
            if(up > 0)
            {
                return true;
            }
            else
            {
                return false;
            }            
        }

        private void btnCriarNota1_Click(object sender, EventArgs e)
        {
            if (CriarNotas(1))
            {
                textBox1.Visible = true;
                textBox1.Enabled = true;
                btnSalvarText1.Visible = true;
                btnDeletarText1.Visible = true;
                btnEditar1.Visible = true;
                btnCriarNota1.Visible = false;

            }

        }

        private void btnCriarNota2_Click(object sender, EventArgs e)
        {
            if (CriarNotas(2))
            {
                textBox2.Visible = true;
                textBox2.Enabled = true;
                btnSalvarText2.Visible = true;
                btnDeletarText2.Visible = true;
                btnEditar2.Visible = true;
                btnCriarNota2.Visible = false;

            }
        }

        private void btnCriarNota3_Click(object sender, EventArgs e)
        {
            if (CriarNotas(3))
            {
                textBox3.Visible = true;
                textBox3.Enabled = true;
                btnSalvarText3.Visible = true;
                btnDeletarText3.Visible = true;
                btnEditar3.Visible = true;
                btnCriarNota3.Visible = false;

            }
        }

        private void btnCriarNota4_Click(object sender, EventArgs e)
        {
            if (CriarNotas(4))
            {
                textBox4.Visible = true;
                textBox4.Enabled = true;
                btnSalvarText4.Visible = true;
                btnDeletarText4.Visible = true;
                btnEditar4.Visible = true;
                btnCriarNota4.Visible = false;

            }
        }

        private void btnCriarNota5_Click(object sender, EventArgs e)
        {
            if (CriarNotas(5))
            {
                textBox5.Visible = true;
                textBox5.Enabled = true;
                btnSalvarText5.Visible = true;
                btnDeletarText5.Visible = true;
                btnEditar5.Visible = true;
                btnCriarNota5.Visible = false;

            }
        }

        private void btnCriarNota6_Click(object sender, EventArgs e)
        {
            if (CriarNotas(6))
            {
                textBox6.Visible = true;
                textBox6.Enabled = true;
                btnSalvarText6.Visible = true;
                btnDeletarText6.Visible = true;
                btnEditar6.Visible = true;
                btnCriarNota6.Visible = false;

            }
        }
                
        private void btnEditarPrestador_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarPrestador();
            f.Show();
            this.Close();
        }

        private void btnEditarUsuario_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarUsuario();
            f.Show();
            this.Close();
        }

        private void btnEditarAdm_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarAdm();
            f.Show();
            this.Close();
        }
        
        private void btnMensagens_Click(object sender, EventArgs e)
        {
            Form f = new Mensagens.frmMensagem();
            f.Show();
            this.Close();
        }

        private void btnEditarServico_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarServico();
            f.Show();
            this.Close();
        }
        
    }
}
