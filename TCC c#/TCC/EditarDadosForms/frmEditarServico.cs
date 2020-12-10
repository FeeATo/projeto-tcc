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

namespace TCC.EditarDadosForms
{
    public partial class frmEditarServico : Form
    {
        SqlConnection sqlCon;
        string connectionString = ConnectionString.StringConexao();
        string output = "";
        Random random = new Random();
        MetodosUtilitarios MetodosUtilitarios = new MetodosUtilitarios();
        

        public frmEditarServico()
        {
            InitializeComponent();
            
            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            lblUsuario.Text = frmLogin.SetLoginName;
            lblNumeroMensagens.Text = MetodosUtilitarios.MsgQntd().ToString();
        }

        //navegação entre os formulários
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

        private void btnNotas_Click(object sender, EventArgs e)
        {
            Form f = new Mensagens.frmNotas();
            f.Show();
            this.Close();
        }

        private void btnMensagens_Click(object sender, EventArgs e)
        {
            Form f = new Mensagens.frmMensagem();
            f.Show();
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

        //houver e leave

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
            lblMarca.BackColor = Color.FromArgb(0, 102, 204);
            lblMarca.ForeColor = Color.White;
        }

        private void btnEditarServico_MouseLeave(object sender, EventArgs e)
        {
            btnEditarServico.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarServico.ForeColor = Color.FromArgb(0, 102, 204);
            lblMarca.BackColor = Color.FromArgb(227, 227, 227);
            lblMarca.ForeColor = Color.FromArgb(0, 102, 204);
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
        }

        private void btnNotas_MouseLeave(object sender, EventArgs e)
        {
            btnNotas.BackColor = Color.FromArgb(227, 227, 227);
            btnNotas.ForeColor = Color.FromArgb(0, 102, 204);
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

        //popula o DataGridView
        public void ShowData()
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();

            string query = "select id_prestservF, id_servico, id_usuF, nome_usu,nome_prestserv,avaliacao,tipo_serv from Servico, Usuario,PrestServ where id_usu = id_usuF and id_prestserv = id_prestservF";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            cmd.ExecuteNonQuery();

            DataTable dt = new DataTable();
            SqlDataAdapter da = new SqlDataAdapter(cmd);

            da.Fill(dt);
            dtDisplay.DataSource = dt;


            sqlCon.Close();
        }

        //Seleciona a linha de acordo com os valores passados, usando o método "SelectServicoByID()"
        //e "SelectServicoByName()"

        private void btnPesquisar_Click_1(object sender, EventArgs e)
        {
            //IDS
            if (txtIdNome.Text != "" || txtIdPrest.Text != "" || txtIdServ.Text != "")
            {
                if (txtIdNome.Text != "")
                {
                    SelectServicoByID(txtIdNome.Text, "usuario");
                    txtIdNome.BackColor = Color.FromArgb(255, 255, 255);
                    txtIdPrest.BackColor = Color.FromArgb(255, 255, 255);
                    txtIdServ.BackColor = Color.FromArgb(255, 255, 255);
                }
                if(txtIdPrest.Text != "")
                {
                    SelectServicoByID(txtIdPrest.Text, "prestserv");
                    txtIdNome.BackColor = Color.FromArgb(255, 255, 255);
                    txtIdPrest.BackColor = Color.FromArgb(255, 255, 255);
                    txtIdServ.BackColor = Color.FromArgb(255, 255, 255);
                }
                if(txtIdServ.Text !="")
                {
                    SelectServicoByID(txtIdServ.Text, "servico");
                    txtIdNome.BackColor = Color.FromArgb(255, 255, 255);
                    txtIdPrest.BackColor = Color.FromArgb(255, 255, 255);
                    txtIdServ.BackColor = Color.FromArgb(255, 255, 255);
                }

                if(txtIdNome.Text != "" && txtIdPrest.Text != "")
                {
                    txtIdNome.BackColor = Color.FromArgb(245, 80, 69);
                    txtIdPrest.BackColor = Color.FromArgb(245, 80, 69);

                    txtIdServ.BackColor = Color.FromArgb(255, 255, 255);
                }
                if(txtIdNome.Text != "" && txtIdServ.Text != "")
                {
                    txtIdNome.BackColor = Color.FromArgb(245, 80, 69);
                    txtIdServ.BackColor = Color.FromArgb(245, 80, 69);

                    txtIdPrest.BackColor = Color.FromArgb(255, 255, 255);
                }
                if (txtIdPrest.Text != "" && txtIdServ.Text != "")
                {
                    txtIdPrest.BackColor = Color.FromArgb(245, 80, 69);
                    txtIdServ.BackColor = Color.FromArgb(245, 80, 69);

                    txtIdNome.BackColor = Color.FromArgb(255, 255, 255);
                }
            }

            //Nomes
            if (txtNomeUsu.Text != "" || txtNomePrest.Text != "")
            {
                if (txtNomeUsu.Text != "")
                {
                    SelectServicoByName(txtNomeUsu.Text, "usuario");
                    txtNomeUsu.BackColor = Color.FromArgb(255, 255, 255);
                    txtNomePrest.BackColor = Color.FromArgb(255, 255, 255);
                    
                }
                if (txtNomePrest.Text != "")
                {
                    SelectServicoByName(txtNomePrest.Text, "prestserv");
                    txtNomeUsu.BackColor = Color.FromArgb(255, 255, 255);
                    txtNomePrest.BackColor = Color.FromArgb(255, 255, 255);
                    
                }
                
                if (txtNomeUsu.Text != "" && txtNomePrest.Text != "")
                {
                    txtNomeUsu.BackColor = Color.FromArgb(245, 80, 69);
                    txtNomePrest.BackColor = Color.FromArgb(245, 80, 69);
                                        
                }
                
            }
        }

        //Métodos para selecionar

        public void SelectServicoByID(string id, string who)
        {
            int i;
            string column = "";
            MetodosUtilitarios count = new MetodosUtilitarios();
            int qtnd = count.ServicoQntd();
            if(who == "usuario")
            {
                column = "txtIDusuario";
            }
            if(who == "servico")
            {
                column = "txtIDservico";
            }
            if(who == "prestserv")
            {
                column = "txtIDprestserv";
            }

            for (i = 0; i < qtnd; i++)
            {
                dtDisplay.Rows[i].Selected = false;

                if (dtDisplay.Rows[i].Cells[column].Value.ToString().Replace(" ", "") == id.ToString().Replace(" ", ""))
                {

                    dtDisplay.Rows[i].Selected = true;
                }
            }
        }

        public void SelectServicoByName(string nome, string who)
        {
            int i;
            string column = "";
            MetodosUtilitarios count = new MetodosUtilitarios();
            int qtnd = count.ServicoQntd();
            if (who == "usuario")
            {
                column = "txtNomeusuario";
            }
            
            if (who == "prestserv")
            {
                column = "txtNomeprestserv";
            }

            for (i = 0; i < qtnd; i++)
            {
                dtDisplay.Rows[i].Selected = false;

                if (dtDisplay.Rows[i].Cells[column].Value.ToString().Replace(" ", "") == nome.Replace(" ", ""))
                {

                    dtDisplay.Rows[i].Selected = true;
                }
            }
        }

        
        private void frmEditarServico_Load(object sender, EventArgs e)
        {
            ShowData();
                                   
        }

        //deleta a linha de acordo com qual linha foi clicada
        private void dtDisplay_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == 0 && e.RowIndex >= 0)
            {
                DataGridViewRow dgvRow = dtDisplay.CurrentRow;
                int ID = int.Parse(dgvRow.Cells["txtIDservico"].Value.ToString());
                DialogResult result = MessageBox.Show("Você quer mesmo deletar este usuário?", "Confirmação", MessageBoxButtons.OKCancel);
                if (result == DialogResult.OK)
                {
                    MetodosUtilitarios.DeleteByID(ID, "Servico");
                    ShowData();
                    
                }
            }
        }

        //Altera ou adiciona valor valores no DataGridView
        private void dtDisplay_CellValueChanged(object sender, DataGridViewCellEventArgs e)
        {
            if (dtDisplay.CurrentRow != null)
            {
                using (SqlConnection sqlCon = new SqlConnection(connectionString))
                {
                    int randomnumber = random.Next();
                    int id = MetodosUtilitarios.UltimoUsuario() + 1;
                    sqlCon.Open();
                    DataGridViewRow dgvRow = dtDisplay.CurrentRow;
                    SqlCommand cmd = new SqlCommand("AddOrEditServico", sqlCon);
                    cmd.CommandType = CommandType.StoredProcedure;

                    if (dgvRow.Cells["txtIDservico"].Value == DBNull.Value)
                        cmd.Parameters.AddWithValue("@id_servico", 0);
                    else
                        cmd.Parameters.AddWithValue("@id_servico", Convert.ToInt32(dgvRow.Cells["txtIDservico"].Value.ToString().Replace(" ", "")));

                    //dgvRow.Cells["txtIDdgv"].Value == DBNull.Value ? "0" : dgvRow.Cells["txtIDdgv"].Value.ToString()

                    cmd.Parameters.AddWithValue("@id_prestservF", Convert.ToInt32(dgvRow.Cells["txtIDprestserv"].Value == DBNull.Value ? "" : dgvRow.Cells["txtIDprestserv"].Value.ToString()));
                    cmd.Parameters.AddWithValue("@nome_prestservF", dgvRow.Cells["txtNomeprestserv"].Value == DBNull.Value ? "" : dgvRow.Cells["txtNomeprestserv"].Value.ToString());
                    cmd.Parameters.AddWithValue("@id_usuF", Convert.ToInt32(dgvRow.Cells["txtIDusuario"].Value == DBNull.Value ? "1" : dgvRow.Cells["txtIDusuario"].Value.ToString()));
                    cmd.Parameters.AddWithValue("@nome_usuF", dgvRow.Cells["txtNomeusuario"].Value == DBNull.Value ? "" : dgvRow.Cells["txtNomeusuario"].Value.ToString());
                    cmd.Parameters.AddWithValue("@avaliacao", Convert.ToInt32(dgvRow.Cells["txtAvaliacao"].Value == DBNull.Value ? "0" : dgvRow.Cells["txtAvaliacao"].Value.ToString()));              
                    

                    
                    //https://www.youtube.com/watch?v=cQQy_IfFddg

                    cmd.ExecuteNonQuery();
                    ShowData();
                }

            }
        }

        public string SelectNomePrestById(int ID)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select nome_prestserv from PrestServ where id_prestserv='" + ID + "'";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }
            sqlCon.Close();
            return output;
        }
                
    }
}
